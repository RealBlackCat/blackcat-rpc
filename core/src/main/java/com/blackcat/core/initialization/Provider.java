package com.blackcat.core.initialization;

import lombok.Data;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/17 10:41
 * @Version 1.0
 * 作为提供者，展示所有标注了要展示的方法,Ip,端口
 */
@Data
public class Provider {
    private Map<String, Map<Method,String>> provideMethodsAndDescription;
    private String ip;
    private String port;
}
