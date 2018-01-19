package JedisTest.ZcyLock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 深谷
 * @serial 2018/1/8 下午7:11.
 */
@Slf4j
@Service
public class LockServiceImpl implements LockService {

//    @Autowired
//    private JedisClientUtil jedisClientUtil;
    @Autowired
    private Jedis jedis;

    private static final String lockValue = "LOCK";
    private static ConcurrentHashMap<String, AtomicInteger> keyReentrantCountMap = new ConcurrentHashMap<>();//重入次数
    private static ConcurrentHashMap<String, Long> keyThreadIdMap = new ConcurrentHashMap<>();//锁的当前持有线程

    /**
     * 尝试获得数据锁 - 获取失败重试
     *
     * @param lockTypeEnum  锁类型
     * @param refBusinessId 业务数据主健
     * @param lockSeconds   锁定时间(秒)
     * @param maxRetryCount 获取不到锁时最大重试次数, 每次间隔50ms;
     * @return true 获得锁, false 获取失败
     */
    @Override
    public boolean tryDataLock(LockTypeEnum lockTypeEnum, String refBusinessId, int lockSeconds, long maxRetryCount) {
        int sleepMills = 50; //每次休眠时间
        String key = this.getDataLockKey(lockTypeEnum, refBusinessId);
        int retryCount = 0;
        while (true) {
            if (jedis.setnx(key, lockValue) > 0) {//得到锁
                jedis.expire(key, lockSeconds);//设置过期时间
                keyThreadIdMap.put(key, Thread.currentThread().getId());
                keyReentrantCountMap.put(key, new AtomicInteger(1));
                log.info("获取锁成功 lockTypeEnum:{}, refBusinessId:{}", lockTypeEnum.getCode(), refBusinessId);
                return true;
            } else {
                AtomicInteger reentrantCount = keyReentrantCountMap.get(key);
                boolean bReentrant = reentrantCount != null && reentrantCount.get() > 0;// 当前锁计数器大于0
                if (keyThreadIdMap.get(key) != null && Thread.currentThread().getId() == keyThreadIdMap.get(key).longValue() && bReentrant) {
                    reentrantCount.incrementAndGet();
                    keyReentrantCountMap.put(key, reentrantCount);
                    log.info("重入锁成功 lockTypeEnum:{}, refBusinessId:{}, reentrantCount:{}", lockTypeEnum.getCode(), refBusinessId, reentrantCount.get());
                    return true; // 实现可重入锁, 防止一直等等
                }
            }
            retryCount++;
            log.debug("maxRetryCount:{}, retryCount:{}", maxRetryCount, retryCount);
            if (maxRetryCount >= retryCount) {
                try {
                    log.warn("没有申请到锁等待中 refBusinessId:{}", refBusinessId);
                    Thread.sleep(sleepMills);
                    if (jedis.ttl(key) < 1) {//没有设置过期时间, 直接删除并立即重新申请
                        jedis.del(key);
                        log.warn("没有设置过期时间, 直接删除并立即重新申请 refBusinessId:{}", refBusinessId);
                        continue;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                log.debug("不重试直接退出 refBusinessId:{}", refBusinessId);
                break;
            }
        }
        return false;
    }

    /**
     * 申请获得数据锁 - 获取失败不重试
     *
     * @param lockTypeEnum  锁类型
     * @param refBusinessId 业务数据主健
     * @param lockSeconds   锁定时间(秒)
     * @return
     */
    @Override
    public boolean acquireDataLock(LockTypeEnum lockTypeEnum, String refBusinessId, int lockSeconds) {
        return this.tryDataLock(lockTypeEnum, refBusinessId, lockSeconds, 0);
    }

    /**
     * 释放锁
     *
     * @param lockTypeEnum  锁类型
     * @param refBusinessId 业务数据主健
     */
    @Override
    public void releaseDataLock(LockTypeEnum lockTypeEnum, String refBusinessId) {
        String key = this.getDataLockKey(lockTypeEnum, refBusinessId);
        AtomicInteger reentrantCount = keyReentrantCountMap.get(key);
        boolean bReentrant = reentrantCount != null && reentrantCount.decrementAndGet() == 0;//当前锁计数器为0
        if (bReentrant && keyThreadIdMap.get(key) != null && Thread.currentThread().getId() == keyThreadIdMap.get(key).longValue()) {
            jedis.del(key);
            log.info("释放锁成功 lockTypeEnum:{}, refBusinessId:{}, reentrantCount:{}", lockTypeEnum.getCode(), refBusinessId, reentrantCount);
        } else {
            log.info("释放锁失败 lockTypeEnum:{}, refBusinessId:{}, reentrantCount:{}", lockTypeEnum.getCode(), refBusinessId, reentrantCount);
        }
    }

    /**
     * 获取分布式锁的key
     *
     * @param lockTypeEnum
     * @param refBusinessId
     * @return
     */
    private String getDataLockKey(LockTypeEnum lockTypeEnum, String refBusinessId) {
        String key = "zcy_inquiry_" + lockTypeEnum.getCode() + "_" + refBusinessId;
        return key;
    }
}
