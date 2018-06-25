package com.Annotation;

import java.lang.annotation.*;

/**
 * 用于过滤html和javascript文本
 *
 * @author 老曹
 * @since 2018/04/26
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface XSSFilter {
    /**
     * 1-过滤检查；2-替换
     * @return
     */
    String value() default "1";
}
