package com.blackcat.demo.config;

import com.blackcat.core.aspect.ConsumerAspect;
import com.blackcat.core.client.ConsumerClient;
import com.blackcat.core.config.RpcApplicationConfig;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/17 16:12
 * @Version 1.0
 */
@Configuration
@Import({ConsumerClient.class,ConsumerAspect.class})//如果有更好的向容器中添加切面的方法，此处可以省略
public class ApplicationConfig  implements ApplicationContextAware {

    @SneakyThrows
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        RpcApplicationConfig.setRPCApplicationContext(applicationContext);
    }
}
