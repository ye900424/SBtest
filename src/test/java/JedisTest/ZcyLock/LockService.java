package JedisTest.ZcyLock;


/**
 * 锁服务
 * @author 深谷
 * @serial 2018/1/8 下午7:11.
 */
public interface LockService {
    /**
     * 尝试获得数据锁 - 获取失败重试
     *
     * @param lockTypeEnum  锁类型
     * @param refBusinessId 业务数据主健
     * @param lockSeconds   锁定时间(秒)
     * @param maxRetryCount 获取不到锁时最大重试次数, 每次间隔50ms;
     * @return true 获得锁, false 获取失败
     */
    boolean tryDataLock(LockTypeEnum lockTypeEnum, String refBusinessId, int lockSeconds, long maxRetryCount);

    /**
     * 申请获得数据锁 - 获取失败不重试
     *
     * @param lockTypeEnum  锁类型
     * @param refBusinessId 业务数据主健
     * @param lockSeconds   锁定时间(秒)
     * @return
     */
    boolean acquireDataLock(LockTypeEnum lockTypeEnum, String refBusinessId, int lockSeconds);

    /**
     * 释放锁
     *
     * @param lockTypeEnum  锁类型
     * @param refBusinessId 业务数据主健
     */
    void releaseDataLock(LockTypeEnum lockTypeEnum, String refBusinessId);
}
