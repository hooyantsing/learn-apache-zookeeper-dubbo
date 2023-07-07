package xyz.hooy.consumer.dubbo;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import xyz.hooy.consumer.api.dubbo.ContextConsumerDubbo;
import xyz.hooy.provider.api.dubbo.ContextProviderDubbo;

import java.util.Map;

@Slf4j
@DubboService
public class ContextConsumerDubboImpl implements ContextConsumerDubbo {

    @DubboReference
    private ContextProviderDubbo contextProviderDubbo;

    @Override
    public String context() {
        // 发 服务提供者 传递参数
        RpcContext.getClientAttachment().setAttachment("consumerKey","consumerValue");
        contextProviderDubbo.invoke("参数");

        // 收 服务提供者 传递参数
        Map<String, Object> clientAttachment = RpcContext.getServerContext().getObjectAttachments();
        log.info("收到提供者传递参数：" + JSON.toJSONString(clientAttachment));
        return JSON.toJSONString(clientAttachment);
    }
}
