package xyz.hooy.provider.dubbo;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import xyz.hooy.provider.api.dubbo.ContextProviderDubbo;

import java.util.Map;

@Slf4j
@DubboService
public class ContextProviderDubboImpl implements ContextProviderDubbo {

    @Override
    public String invoke(String param) {
        // 收 服务消费者 传递参数
        Map<String, Object> serverAttachments = RpcContext.getServerAttachment().getObjectAttachments();
        log.info("收到消费者传递参数：" + JSON.toJSONString(serverAttachments));

        // 发 服务消费者 传递参数
        RpcContext.getServerContext().setAttachment("providerKey", JSON.toJSONString(serverAttachments));
        return param;
    }
}
