package xyz.hooy.consumer.service.impl;

import com.alibaba.fastjson2.JSON;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Service;
import xyz.hooy.consumer.service.ContextService;
import xyz.hooy.provider.api.dubbo.ContextDubbo;

import java.util.Map;

@Service
public class ContextServiceImpl implements ContextService {

    @DubboReference
    private ContextDubbo contextDubbo;

    @Override
    public void context() {
        //往服务端传递参数
        RpcContext.getClientAttachment().setAttachment("clientKey1","clientValue1");
        String res = contextDubbo.invoke("context1");
        //接收传递回来参数
        Map<String, Object> clientAttachment = RpcContext.getServerContext().getObjectAttachments();
        System.out.println("ContextTask clientAttachment:" + JSON.toJSONString(clientAttachment));
        System.out.println("ContextService Return : " + res);
    }
}
