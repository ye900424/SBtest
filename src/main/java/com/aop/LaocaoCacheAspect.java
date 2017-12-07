package com.aop;

import com.service.FunInter;
import com.service.FunInterImpl1;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by C.A.O on 2017/11/18.
 */
@Aspect
@Slf4j
@Component
public class LaocaoCacheAspect implements Ordered{

    //所有的方法
//    @Pointcut("execution(* *(..))")
    //controller下面的类、下面所有的包
    @Pointcut("execution(public * com.service.*.*(..)) && args(String,Integer)")
    public void cutMethod() {
        //空方法，作切入点
    }





    @Around(value = "cutMethod()")
    public Object aroundHandler(final ProceedingJoinPoint joinPoint){
        Object obj = null;

        try {
            log.info("方法名：" + joinPoint.toString());
            log.info("方法名：" + joinPoint.toShortString());
            log.info("方法名：" + joinPoint.toLongString());

            Object args[] = joinPoint.getArgs();

            Long time1 = System.currentTimeMillis();
            obj = joinPoint.proceed();
            Long time2 = System.currentTimeMillis();

            log.info("消耗时间1：" + (time2-time1) + "ms");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }


    @Override
    public int getOrder() {
        return 2;
    }

//
    @DeclareParents(value = "com.service.TestService", defaultImpl =FunInterImpl1.class)
    public static FunInter funInter;
}
