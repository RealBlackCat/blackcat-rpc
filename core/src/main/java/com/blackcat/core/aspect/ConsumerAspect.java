package com.blackcat.core.aspect;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.blackcat.core.client.ConsumerClient;
import com.blackcat.core.protocol.RpcRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/23 9:04
 * @Version 1.0
 */
@Aspect
@Component
public class ConsumerAspect {
    @Autowired
    private ConsumerClient consumerClient;

    @Pointcut("@within(com.blackcat.core.annotation.RequiredMethodInterface)")
    private void RequiredMethodInterfacePoint(){};


    @Around("RequiredMethodInterfacePoint()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        String signature = joinPoint.getSignature().toString();
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setRequestId(UUID.fastUUID().toString());
        rpcRequest.setMethodNameAndParameter(StrUtil.subSuf(signature, signature.lastIndexOf(".")+1));
        rpcRequest.setParameters(joinPoint.getArgs());
        System.out.println(123);
    }
}
