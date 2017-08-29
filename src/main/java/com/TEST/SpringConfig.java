package com.TEST;

/**
 * Created by caoyang on 2017/7/25.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class SpringConfig {

    @Bean
    public Piano piano() {
        return new Piano();
    }

    @Bean(name = "counter")
    public Counter counter() {
        return new Counter(12, "Shake it Off", piano());
    }
}
