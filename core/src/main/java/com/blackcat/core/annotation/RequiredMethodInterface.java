package com.blackcat.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/23 8:59
 * @Version 1.0
 * 客户端用来标注需要从服务端获取的方法接口
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredMethodInterface {
}
