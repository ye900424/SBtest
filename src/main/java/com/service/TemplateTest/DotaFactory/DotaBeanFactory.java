package com.service.TemplateTest.DotaFactory;

import com.service.TemplateTest.DotaService;
import com.service.TemplateTest.PlayerType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by C.A.O on 2017/11/3.
 */
@Component
public class DotaBeanFactory implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;
    public static ConcurrentHashMap<PlayerType, DotaService> beanMap = new ConcurrentHashMap();

    /**
     * 实现ApplicationContextAware.setApplicationContext(),初始化类实例
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

       this.applicationContext = applicationContext;

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Collection<DotaService> dotaServiceList = this.applicationContext.getBeansOfType(DotaService.class).values();
        dotaServiceList.forEach(x -> {
            beanMap.put(x.getPlayerType(),x);
        });
    }
}
