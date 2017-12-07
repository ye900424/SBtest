package com.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by C.A.O on 2017/11/18.
 */
@Aspect
@Slf4j
@Component
@Order(1)
public class LaocaoCacheAspect2 {


    @Pointcut("@annotation(com.Annotation.CaoCache)")
    public void cutAnnotation(){

    }




    @Around("cutAnnotation()")
    public Object anAroundHandler(final ProceedingJoinPoint joinPoint){
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



}
