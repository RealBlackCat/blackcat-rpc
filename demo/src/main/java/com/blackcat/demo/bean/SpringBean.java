package com.blackcat.demo.bean;


import com.blackcat.core.annotation.ProvideMethod;
import com.blackcat.core.annotation.RequiredMethodInterface;
import org.springframework.stereotype.Service;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/17 11:49
 * @Version 1.0
 */
@Service
@RequiredMethodInterface
public class SpringBean {
    private  String name="黑猫";

    @ProvideMethod(description = "这是注解")
    public void get(String a,String b){
        System.out.println("!@3213");
    }
}
