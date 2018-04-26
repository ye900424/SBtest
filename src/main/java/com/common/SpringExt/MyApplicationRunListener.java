package com.common.SpringExt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * Created by C.A.O on 2018/4/24.
 */
public class MyApplicationRunListener implements SpringApplicationRunListener{

    public MyApplicationRunListener() {}

    public MyApplicationRunListener(SpringApplication application, String... args) {}

    @Override
    public void started() {
        System.out.println("启动监听器：MyApplicationRunListener.started");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("启动监听器：MyApplicationRunListener.environmentPrepared");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("启动监听器：MyApplicationRunListener.contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("启动监听器：MyApplicationRunListener.contextLoaded");
    }

    @Override
    public void finished(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("启动监听器：MyApplicationRunListener.finished");
    }
}
