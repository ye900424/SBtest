package com.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by C.A.O on 2017/12/14.
 */
@Aspect
@Slf4j
@Component
public class CheckDaoAspect {

    @Pointcut("@annotation(com.Annotation.CheckDao)")
    public void cutMethod(){

    }

//    @Pointcut("execution(public * com.dao.*.*(..))")
//    public void cutMethod() {
//        //空方法，作切入点
//    }


    @Around("cutMethod()")
    public Object CheckDaoAround(final ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        System.out.println("拦截方法："+method.getName());


        //继续执行方法
        Object obj = "";
        try {
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

//    @Before("cutMethod()")
//    public void CheckDaoBefore(){
//
//    }
}
