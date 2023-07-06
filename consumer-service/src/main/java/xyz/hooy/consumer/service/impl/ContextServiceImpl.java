package xyz.hooy.consumer.service.impl;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.stereotype.Service;
import xyz.hooy.consumer.service.ContextService;
import xyz.hooy.provider.api.dubbo.ContextDubbo;

import java.util.Map;

@Slf4j
@Service
public class ContextServiceImpl implements ContextService {

    @DubboReference
    private ContextDubbo contextDubbo;

    @Override
    public String context() {
        // 发 服务提供者 传递参数
        RpcContext.getClientAttachment().setAttachment("consumerKey","consumerValue");
        contextDubbo.invoke("参数");

        // 收 服务提供者 传递参数
        Map<String, Object> clientAttachment = RpcContext.getServerContext().getObjectAttachments();
        log.info("收到提供者传递参数：" + JSON.toJSONString(clientAttachment));
        return JSON.toJSONString(clientAttachment);
    }
}
