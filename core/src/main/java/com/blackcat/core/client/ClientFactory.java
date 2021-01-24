package com.blackcat.core.client;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author RealBlcakCat
 * @Date 2021/1/23 17:01
 * @Version 1.0
 */
public class ClientFactory {
    private static final Map<String,Client> clients=new HashMap<>();
    static {
        clients.put("center",new CenterClient());
        clients.put("consumer",new ConsumerClient());
        clients.put("provider",new ProviderClient());
    }
    public static Client getInstance(@NonNull String clientIndentity){
        Client client = clients.get(clientIndentity);
        if(ObjectUtil.isNull(client)) throw new IllegalArgumentException("客户端身份错误");
        return  client;
    }
}
