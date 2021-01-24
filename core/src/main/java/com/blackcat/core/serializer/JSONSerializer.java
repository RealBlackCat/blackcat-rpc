package com.blackcat.core.serializer;


import com.alibaba.fastjson.JSON;

import java.io.IOException;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/20 21:01
 * @Version 1.0
 */
public class JSONSerializer implements Serializer{
    @Override
    public byte[] serialize(Object object) throws IOException {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) throws IOException {
        return JSON.parseObject(bytes,clazz);
    }
}
