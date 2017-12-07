package com.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by C.A.O on 2017/11/18.
 * 缓存测试-注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
//@Target(ElementType.TYPE)
public @interface CaoCache {
}
