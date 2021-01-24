package com.blackcat.core.asyn;

import com.blackcat.core.protocol.RpcResponse;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/20 21:35
 * @Version 1.0
 */
public class DefaultFuture {
    private RpcResponse rpcResponse;
    //实际上用了wait和notify机制，同时使用一个boolean变量做辅助
    private volatile boolean isSucceed = false;
    private final Object object = new Object();

    public RpcResponse getRpcResponse(int timeout) {
        synchronized (object) {
            while (!isSucceed) {
                try {
                    object.wait(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return rpcResponse;
        }
    }

    public void setResponse(RpcResponse response) {
        if (isSucceed) {
            return;
        }
        synchronized (object) {
            this.rpcResponse = response;
            this.isSucceed = true;
            object.notify();
        }
    }
}