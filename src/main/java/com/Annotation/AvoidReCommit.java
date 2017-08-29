package com.Annotation;

import java.lang.annotation.*;

/**
 * Redis实现防重的注解
 * Created by zhouzongkun on 2017/4/27.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AvoidReCommit {
    /** redis锁key的前缀，默认为"fixed"*/
    String lockedPrefix() default "";
    /** key在redis里存在的时间，时间为秒*/
    int expiredTime() default 2;
}
