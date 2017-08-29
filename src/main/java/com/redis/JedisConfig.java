package com.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * Created by caoyang on 2017/7/27.
 */
@Configuration
@ConfigurationProperties(prefix = "redis")
public class JedisConfig {

    private String hostname;
    private int port;
    private String password;

    public Jedis getJedisSource(){
        Jedis jedis = new Jedis(hostname,port);
        jedis.auth(password);
        return jedis;
    }

    public String getHostname() {
        return hostname;
    }

    public int getPort() {
        return port;
    }

    public String getPassword() {
        return password;
    }


    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
