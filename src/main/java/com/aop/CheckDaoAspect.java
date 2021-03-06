package com.aop;

import com.Annotation.CaoCache;
import com.Annotation.CheckDao;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by C.A.O on 2017/12/14.
 */
@Aspect
@Slf4j
@Component
public class CheckDaoAspect {

//    @Pointcut("@annotation(com.Annotation.CheckDao)")
//    public void cutMethod(){
//
//    }

    @Pointcut("@within(com.Annotation.CheckDao) && execution(public * *(..))")
    public void cutMethod() {
    }

//    @Pointcut("execution(public * com.dao.*.*(..))")
//    public void cutMethod() {
//        //空方法，作切入点
//    }

    /**
     * Around切面处理
     * @param joinPoint
     * @return
     */
    @Around("cutMethod()")
    public Object CheckDaoAround(final ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Class clazz = joinPoint.getTarget().getClass();

        System.out.println("拦截类："+clazz.getName());
        System.out.println("拦截方法："+method.getName());


        method.isAnnotationPresent(CheckDao.class);
        method.isAnnotationPresent(CaoCache.class);

        clazz.isAnnotationPresent(CheckDao.class);
        clazz.isAnnotationPresent(CaoCache.class);

        Object[] args = joinPoint.getArgs();

        method.getClass().getAnnotations();
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation annotation : annotations){


        }




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
