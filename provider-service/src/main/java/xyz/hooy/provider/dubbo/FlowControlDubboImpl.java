package xyz.hooy.provider.dubbo;

import lombok.SneakyThrows;
import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.provider.api.dubbo.FlowControlDubbo;

@DubboService
public class FlowControlDubboImpl implements FlowControlDubbo {

    @Override
    @SneakyThrows
    public String timeout(){
        // 模拟业务超时
        Thread.sleep(5 * 1000);
        return "OK";
    }
}
