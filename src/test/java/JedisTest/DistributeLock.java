package JedisTest;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * @author: C.A.O
 * @Description: 分布式锁
 * @Date: 2018/12/12
 */
@Slf4j
@Component
public class DistributeLock {

    @Autowired
    private Jedis jedis;

    private static final String LOCK = "LOCK";
    private static final int DEFAULT_SECONDS = 5;
    private static final int DEFAULT_RETRY_COUNTS = 10;

    /**
     * 此方法只会尝试获取一次锁，不管结果如何立即返回
     *
     * @param key 锁的key
     * @return true：获取到锁 | false：没获取到锁
     */
    public Boolean lock(String key, Integer lockSeconds) {
        // 只尝试一次
        return this.tryLock(key, lockSeconds, 0);
    }

    /**
     * 此方法会根据入参 maxRetryCounts ，重复多次获取锁，每次间隔50ms
     *
     * @param key            锁的key
     * @param lockSeconds    锁超时时间
     * @param maxRetryCounts 重试次数
     * @return true：获取到锁 | false：没获取到锁
     */
    public Boolean tryLock(String key, Integer lockSeconds, Integer maxRetryCounts) {
        int retryCounts = 0;
        long interval = 50;

        lockSeconds = null == lockSeconds ? DEFAULT_SECONDS : lockSeconds;
        maxRetryCounts = null == maxRetryCounts ? DEFAULT_RETRY_COUNTS : maxRetryCounts;

        // 入参合法校验
        if (lockSeconds < 0) {
            log.warn("lockSeconds must be positive,key:{},lockSeconds:{}", key, lockSeconds);
            throw new RuntimeException("lockSeconds must be positive");
        }

        // 没获取到锁进去while循环
        while (null == jedis.set(key, LOCK, "nx", "ex", lockSeconds)) {
            if (retryCounts >= maxRetryCounts) {
                // 重试次数超过最大值，获取失败
                log.info("fail to get distribute lock,key:{},retryCounts:{}", key, retryCounts);
                return Boolean.FALSE;
            }

            try {
                // 默认50ms重试一次
                TimeUnit.MILLISECONDS.sleep(interval);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.warn("error.in.waitting.lock,key:{},cause:{}", key, Throwables.getStackTraceAsString(e));
                return Boolean.FALSE;
            }

            retryCounts++;
        }
        log.info("success to get distribute lock,key:{},retryCounts:{}", key);
        return Boolean.TRUE;
    }

    /**
     * 释放锁
     *
     * @param key
     * @return
     */
    public boolean releaseLock(String key) {
        try {
            return jedis.del(key) > 0 || !jedis.exists(key);
        } catch (Exception e) {
            log.warn("fail.release.lock,key:{}, cause:{}", key, Throwables.getStackTraceAsString(e));
            return false;
        }
    }

}
