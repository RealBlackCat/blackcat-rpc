package com.blackcat.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/17 10:15
 * @Version 1.0
 * 标注提供的方法
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProvideMethod {
    String description() default "";

}
