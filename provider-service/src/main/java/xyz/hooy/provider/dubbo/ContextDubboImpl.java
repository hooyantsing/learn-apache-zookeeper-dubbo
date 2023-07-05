package xyz.hooy.provider.dubbo;

import com.alibaba.fastjson2.JSON;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import xyz.hooy.provider.api.dubbo.ContextDubbo;

import java.util.Map;

@DubboService
public class ContextDubboImpl implements ContextDubbo {

    @Override
    public String invoke(String param) {
        // ServerAttachment接收客户端传递过来的参数
        Map<String, Object> serverAttachments = RpcContext.getServerAttachment().getObjectAttachments();
        System.out.println("ContextService serverAttachments:" + JSON.toJSONString(serverAttachments));
        // 往客户端传递参数
        RpcContext.getServerContext().setAttachment("serverKey", "serverValue");
        StringBuilder s = new StringBuilder();
        s.append("ContextService param:").append(param);
        return s.toString();
    }
}
