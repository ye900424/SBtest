package com.redis;

import com.domain.User_fun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by caoyang on 2017/4/11.
 */
@Configuration
public class JedisClusterConfig {

    @Autowired
    private RedisConfig redisConfig;

    /**
     * 注意：
     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用
     * @return
     */
    @Bean
    public JedisCluster getJedisCluster() {
        String[] serverArray = redisConfig.getClusterNodes().split(",");//获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
        Set<HostAndPort> nodes = new HashSet<>();

        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }

        return new JedisCluster(nodes, redisConfig.getCommandTimeout());
    }

    @Bean
    public User_fun getUserTest(){
        User_fun user = new User_fun();
        user.setId(666);
        user.setUsername("caoyang");
        user.setPassword("cao890809");
        return user;
    }

}
