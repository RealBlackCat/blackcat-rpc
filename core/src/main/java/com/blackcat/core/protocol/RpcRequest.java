package com.blackcat.core.protocol;

import lombok.Data;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/20 20:50
 * @Version 1.0
 */
@Data
public class RpcRequest {
    /**
     * 请求ID
     */

    private String requestId;
    /**
     * 方法名(参数类型)
     */
    private String methodNameAndParameter;
    /**
     * 入参
     */
    private Object[] parameters;

}
