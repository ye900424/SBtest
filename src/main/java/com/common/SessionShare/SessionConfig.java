package com.common.SessionShare;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by caoyang on 2017/5/23.
 * 这个类用配置redis服务器的连接
 * maxInactiveIntervalInSeconds为SpringSession的过期时间（单位：秒）
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 1800)
public class SessionConfig {

    @Value("${redis.hostname:121.42.253.157}")
    private String hostname;
    @Value("${redis.port:6379}")
    private int port;

    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setHostName(hostname);
        connection.setPort(port);
        return connection;
    }
}
