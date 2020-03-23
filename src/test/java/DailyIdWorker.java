import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Calendar;
import java.util.HashMap;

/**
 * @author 深谷
 *
 * 为了解决类似这种需求， 年月日+8位随机唯一数值，保证单号当日唯一， 最好不要能看出一天的订单总数。例：2018112501234567
 * 部分id使用类雪花算法来实现
 *
 * 8位，即最大值99999999 - 可用 27位表示(0~134217728);
 * 当天秒数偏移值 + workerId + sequence = 27
 * 一天总秒数 86400, 用 17 表示(0~131072)
 * workerId + sequence = 10位
 * workerId 3位
 * sequence 7位
 *
 *当前配置下的最大id: testQueryMaxIdByConfig()  88472704
 *
 * 如果系统的并发量大，WORKER_ID_BITS 和 SEQUENCE_BITS 建议调整为更大值(但相应的id字符长度 ID_LENGTH 也会跟着增长); 例：6， 10
 */
@Slf4j
public class DailyIdWorker {

    // 服务节点所占位数，TODO 如果并发量大，建议调整为更大值
    private int WORKER_ID_BITS = 3;
    // 秒内序列所占位数, TODO 如果并发量大，建议调整为更大值
    private int SEQUENCE_BITS = 7;
    // id字符长度, TODO 如果并发量大，建议调整为更大值
    private int ID_LENGTH = 8;

    // 最大服务节点id
    private final int MAX_WORKER_ID = (1 << WORKER_ID_BITS);
    // 秒内最大序列
    private final int MAX_SEQUENCE = (1 << SEQUENCE_BITS);

    /** 当前服务节点id (0 ~ MAX_WORKER_ID) **/
    private int currentWorkerId;

    /** 秒内序列(0~MAX_SEQUENCE) */
    private long sequence = 0L;
    /** 上次生成ID的距今天00:00:00到现在的秒数 */
    private long lastSeconds = -1L;

    // 参考时间, 2016-01-01 00:00:00
    private final static long twepoch;
    static {
        // 初始化本服务的参考时间
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, Calendar.JANUARY, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        twepoch = calendar.getTimeInMillis();
    }

    public DailyIdWorker(int workerId, Integer workerIdBits, Integer sequenceBits, Integer idLength) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        this.currentWorkerId = workerId;
        if (workerIdBits != null) {
            WORKER_ID_BITS = workerIdBits;
        }
        if (sequenceBits != null) {
            SEQUENCE_BITS = sequenceBits;
        }
        if (idLength != null) {
            ID_LENGTH = idLength;
        }
    }

    /**
     * 构造函数
     * @param workerId 工作ID (0~MAX_WORKER_ID)
     */
    public DailyIdWorker(int workerId) {
        this(workerId, null, null, null);
    }

    // ==============================Methods==========================================
    /**
     * 获得下一个ID (该方法是线程安全的)
     * @return SnowflakeId
     */
    public synchronized String nextId() {
        long timestamp =  System.currentTimeMillis();
        // 距今天00:00:00到现在的秒数
        long secondsOffset = getDaySecondsOffset(timestamp);

        //如果当前时间小于上一次ID生成的秒数偏移，说明系统时钟回退过，这个时候一直等待
        if (secondsOffset < lastSeconds) {
            timestamp = waitUntilNextTime(lastSeconds);
            secondsOffset = getDaySecondsOffset(timestamp);
        }

        // 如果是同一时间生成的，则进行毫秒内序列
        if (lastSeconds == secondsOffset) {
            sequence = sequence + 1;
            if (sequence >= MAX_SEQUENCE) {
                timestamp = tilNextMills();
                secondsOffset = getDaySecondsOffset(timestamp);
                sequence = 0L;
            }
        }
        //时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }

        // 上次生成ID的时间截(秒偏移量)
        lastSeconds = secondsOffset;

        String today = DateFormatUtils.format(timestamp, "yyyyMMdd");

        // 移位并通过或运算拼到一起组成的ID
        long id = (secondsOffset << (WORKER_ID_BITS + SEQUENCE_BITS))
                | (currentWorkerId << SEQUENCE_BITS)
                | sequence;
        log.debug("secondsOffset:{}, workerId:{}, sequence:{}, id:{}", secondsOffset, currentWorkerId, sequence, id);
        String idFormat = formatId(id+"", ID_LENGTH);
        return today + idFormat;
    }

    /**
     * 时钟回拨; 不停获得时间，直到大于最后时间
     * @param lastTime 最后时间戳
     * @return
     */
    private long waitUntilNextTime(final long lastTime) {
        long time = System.currentTimeMillis();
        while (time <= lastTime) {
            time = System.currentTimeMillis();
        }
        return time;
    }

    /**
     * 阻塞到下一个秒，直到获得新的时间戳
     * @return 当前时间戳
     */
    protected long tilNextMills() {
        long timestamp = timeGen();
        while (true) {
            if ((getDaySecondsOffset(timestamp) - lastSeconds) >= 1) {
                break;
            }
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 获得距今天00:00:00到现在过去的秒数， 最大值为86399
     * @param timestamp
     * @return
     */
    protected long getDaySecondsOffset(long timestamp) {
        long value = ((timestamp - twepoch) % (24 * 60 * 60 * 1000)) / 1000;
        return value;
    }

    /**
     * 返回以毫秒为单位的当前时间
     * @return 当前时间(毫秒)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 根据id长度对id进行补齐，例id 430, length 8;  返回为 00000430
     * @param id
     * @param length
     * @return
     */
    public static String formatId(String id, int length) {
        if (id.length() >= length) {
            return id;
        }
        String result = id;
        for (;result.length() < length;) {
            result = "0" + result;
        }
        return result;
    }

    public static void main(String[] args) {
        testBatchRetrieveId();

        //查询当前配置下的最大id
        testQueryMaxIdByConfig();
    }

    /**
     * 查询当前配置下的最大id
     */
    private static void testQueryMaxIdByConfig() {
        // 一天的所有秒数为86400, 所以最大秒偏移是86400 - 1;
        Long secondsOffset = 86399L;
        DailyIdWorker dailyIdWorker = new DailyIdWorker(3);
        int workerId = dailyIdWorker.MAX_WORKER_ID;
        int sequence = dailyIdWorker.MAX_SEQUENCE;
        int currentWorkerId = workerId;
        long result = (secondsOffset << (dailyIdWorker.WORKER_ID_BITS + dailyIdWorker.SEQUENCE_BITS))
                | (currentWorkerId << dailyIdWorker.SEQUENCE_BITS)
                | sequence;
        System.out.println("当前配置下的最大id: " + result);
        log.info("secondsOffset:{}, workerId:{}, sequence:{}, result:{}", secondsOffset, currentWorkerId, sequence, result);
    }

    /**
     * 批量获取id
     */
    private static void testBatchRetrieveId() {
        long begin = System.currentTimeMillis();
        HashMap<String, String> map = new HashMap<>();
        // workerId 应该通过环境变量、hostName, ip等计算出来
        DailyIdWorker dailyIdWorker = new DailyIdWorker(2, 3, 7, 8);
        for (int i = 0; i < 1000; i++) {
            String id = dailyIdWorker.nextId();
            if (map.containsKey(id)) {
                throw new RuntimeException("单号有重复");
            }
            map.put(id, id);
            log.info("第{}个id, {}", i+1, id);
        }
        log.info("花费的毫秒数:{}", System.currentTimeMillis() - begin);
        // 每天总共 86400 秒
        long maxSecondsVal = (86399 << (dailyIdWorker.WORKER_ID_BITS + dailyIdWorker.SEQUENCE_BITS));
        System.out.println("一天所有秒在id高位中的最大值：" +  maxSecondsVal);
        System.out.println("所有实例每秒最大请求数：" + dailyIdWorker.MAX_WORKER_ID * dailyIdWorker.MAX_SEQUENCE);
        System.out.println("实例最多:" + dailyIdWorker.MAX_WORKER_ID + ", 每个实例每秒最大请求数:" + dailyIdWorker.MAX_SEQUENCE);
    }
}
