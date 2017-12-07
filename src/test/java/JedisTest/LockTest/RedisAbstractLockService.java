package JedisTest.LockTest;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by C.A.O on 2017/11/7.
 */
public abstract class RedisAbstractLockService implements LockService {
    private final String LOCK_VALUE = "DIS_LOCK";

    private JedisCluster jedisCluster;

    private Integer retryCount = 50;

    private Jedis jedis;

    private Integer expireSeconds = 30;


    {
        Jedis jedis = new Jedis("121.42.253.157", 6380);
        jedis.auth("cao890809");
        this.jedis = jedis;
    }


    @Override
    public boolean tryLock(String lockKey) {

        while (true){
            Integer count = 0;

            long lockValue = jedis.setnx(lockKey, LOCK_VALUE);
            if (lockValue == 1) {
                //获得锁
                jedis.expire(lockKey, expireSeconds);
                System.out.println("获得锁");
                return true;
            }

            count++;
            if(count >= retryCount){
                return false;
            }

            if (jedis.ttl(lockKey) < 0) {
                System.out.println(lockKey + " 没有失效时间，直接删除。");
                jedis.del(lockKey);
            }
        }


//        return false;
    }

    @Override
    public boolean release(String lockKey) {
        jedis.del(lockKey);
        return false;
    }

    /**
     * 业务操作
     */
    public abstract void execute();

    /**
     * 初始化jedisCluster
     */
    public void setJedisCluster() {
        String[] serverArray = "121.42.253.157:7000".split(",");//获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
        Set<HostAndPort> nodes = new HashSet<>();

        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }

        this.jedisCluster = new JedisCluster(nodes, 1000);
    }

    /**
     * 初始化jedis
     */
    public static void setJedis() {

    }

    /**
     * 设置超市时间
     */
    protected void setSeconds(Integer expireSeconds) {
        this.expireSeconds = expireSeconds;
    }


    public static void main(String[] args) {
        RedisAbstractLockService redisAbstractLockService = new RedisAbstractLockService() {
            @Override
            public void execute() {

            }
        };

        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                redisAbstractLockService.tryLock("laocao");
            } catch (Exception e) {
                System.out.println("获取锁失败～");
                System.out.println(e.getMessage());
            } finally {
                redisAbstractLockService.release("laocao");
            }
        }
    }
}
