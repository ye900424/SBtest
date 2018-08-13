package com.Util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by caoyang on 2017/7/26.
 */
@Component
public class AppUtil implements ApplicationContextAware{
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBean(String className){
//        applicationContext.getBean(FunInter.class).helloWorld();
//        applicationContext.getBeansOfType(FunInter.class).get("funInterImpl2").helloWorld();
        return applicationContext.getBean(className);
    }
}
