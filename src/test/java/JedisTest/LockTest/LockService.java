package JedisTest.LockTest;

/**
 * Created by C.A.O on 2017/11/7.
 */
public interface LockService {

    /**
     * 尝试加锁并获得锁
     * @return
     */
    public boolean tryLock(String lockKey);


    /**
     * 释放锁
     * @return
     */
    public boolean release(String lockKey);
}
