package com.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by caoyang on 2017/4/10.
 */

@SpringBootApplication
@EnableSwagger2             //启动swagger注解
@ComponentScan(
        value = {
                "com.*"
        }
)
//@ImportResource(locations = {"classpath:spring/*.xml"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
