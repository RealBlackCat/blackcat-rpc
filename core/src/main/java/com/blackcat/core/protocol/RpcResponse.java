package com.blackcat.core.protocol;

import lombok.Data;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/20 20:55
 * @Version 1.0
 */
@Data
public class RpcResponse {
    /**
     * 响应ID
     */
    private String requestId;
    /**
     * 错误信息
     */
    private String error;
    /**
     * 响应结果
     */
    private Object result;
    /**
     * IP
     */
    private  String ip;
    /**
     * 端口号
     */
    private String port;
}
