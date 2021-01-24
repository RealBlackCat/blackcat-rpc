package com.blackcat.core.config;

import com.blackcat.core.initialization.Provider;
import com.blackcat.core.util.RpcSpringUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/17 19:40
 * @Version 1.0*
 *
 */
public  class RpcApplicationConfig {


    public static void setRPCApplicationContext(ApplicationContext applicationContext) throws Exception {
        RpcSpringUtil.getInstance().setApplicationContext(applicationContext);
        Environment environment = applicationContext.getEnvironment();
        if("provider".equals(environment.getProperty("rpc.indentity"))){
            Map<String,Object> providerMap=new HashMap<>();
            providerMap.put("provideMethodsAndDescription", RpcSpringUtil.getProvideMethodsAndDescription());
            providerMap.put("ip", InetAddress.getLocalHost().getHostAddress());
            providerMap.put("port", environment.getProperty("server.port","8080"));
            RpcSpringUtil.dynamicCreateBean(Provider.class,providerMap);
        }
//        RpcSpringUtil.dynamicCreateBean(ClientFactory.getInstance(environment.getProperty("rpc.indentity")).getClass());
    }

}
