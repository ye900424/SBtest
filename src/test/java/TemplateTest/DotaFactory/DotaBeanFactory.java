package TemplateTest.DotaFactory;

import TemplateTest.DotaService;
import TemplateTest.PlayerType;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by C.A.O on 2017/11/3.
 */
public class DotaBeanFactory implements ApplicationContextAware{

    private ApplicationContext applicationContext;
    private static ConcurrentHashMap<PlayerType, DotaService> beanMap = new ConcurrentHashMap();

    /**
     * 实现ApplicationContextAware.setApplicationContext(),初始化类实例
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        Collection<DotaService> dotaServiceList = this.applicationContext.getBeansOfType(DotaService.class).values();
        dotaServiceList.forEach(x -> {
            beanMap.put(x.getPlayerType(),x);
        });

    }
}
