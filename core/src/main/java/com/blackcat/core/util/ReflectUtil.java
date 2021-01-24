package com.blackcat.core.util;

import java.lang.reflect.Method;
import java.util.StringJoiner;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/17 17:57
 * @Version 1.0
 */
public class ReflectUtil {

    public static String getMehthodNameAndParameter(Method method){
        StringJoiner mehthodNameAndParameter=new StringJoiner(method.getName()+"(",",",")");
        Class<?>[] parameterTypes = method.getParameterTypes();
        for (Class<?> parameterType : parameterTypes) {
            mehthodNameAndParameter.add(parameterType.getSimpleName());
        }
        return mehthodNameAndParameter.toString();
    }


}
