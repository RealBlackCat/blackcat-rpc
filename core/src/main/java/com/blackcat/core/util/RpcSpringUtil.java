package com.blackcat.core.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.blackcat.core.annotation.ProvideMethod;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/17 11:39
 * @Version 1.0
 */
@Component
public final class RpcSpringUtil {
    private  static RpcSpringUtil instance=new RpcSpringUtil();
    private  ApplicationContext applicationContext;
    private RpcSpringUtil(){}
    private   ApplicationContext getApplicationContext() {
        return instance.applicationContext;
    }
    public  void setApplicationContext(ApplicationContext applicationContext) {
        if(instance.applicationContext==null)  instance.applicationContext = applicationContext;
    }

    public static String[] getBeanNames(){
        return  instance.applicationContext.getBeanDefinitionNames();
    }

    public static Map<String, Map<Method,String>>  getProvideMethodsAndDescription( ){
        Map<String, Map<Method,String>> provideMethodsAndDescription=new HashMap<>();
        ApplicationContext applicationContext = instance.applicationContext;
        for (String beanName : applicationContext.getBeanNamesForAnnotation(ProvideMethod.class)) {
            Object bean = getBean(beanName);
            for (Method method : bean.getClass().getMethods()) {
                ProvideMethod annotation = method.getAnnotation(ProvideMethod.class);
                if(annotation==null) continue;
                Map<Method,String> map=new HashMap<>();
                map.put(method,annotation.description());
                provideMethodsAndDescription.put(ReflectUtil.getMehthodNameAndParameter(method),map);
            }
        }
        return  provideMethodsAndDescription;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
        return instance.applicationContext.getBean(name);
    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return instance.applicationContext.getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return instance.applicationContext.getBean(name, clazz);
    }

    public static RpcSpringUtil getInstance(){
        return  instance;
    }

    public static <T>void dynamicCreateBean(@NotNull Class<T> clz, @NotNull Map<String, Object> value) throws Exception {
        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext)instance.applicationContext;
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)applicationContext.getBeanFactory();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(clz);
        Field[] declaredFields = clz.getDeclaredFields();
        if(ObjectUtil.isNotEmpty(declaredFields)){
            for (Field declaredField : clz.getDeclaredFields()) {
                beanDefinitionBuilder.addPropertyValue(declaredField.getName(), value.get(declaredField.getName()));
            }
        }
        beanFactory.registerBeanDefinition(StrUtil.lowerFirst(clz.getSimpleName()), beanDefinitionBuilder.getBeanDefinition());
    }
    public static <T>void dynamicCreateBean(Class<T> clz) throws Exception {
        dynamicCreateBean(clz,new HashMap<String, Object>());
    }

}
