package xyz.hooy.provider.dubbo;

import lombok.SneakyThrows;
import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.provider.api.dubbo.FlowControlDubbo;

import java.util.concurrent.ThreadLocalRandom;

@DubboService
public class FlowControlDubboImpl implements FlowControlDubbo {

    @Override
    @SneakyThrows
    public String timeout() {
        // 模拟业务超时
        Thread.sleep(5 * 1000);
        return "响应超时调用成功";
    }

    @Override
    public String retry() {
        int i = ThreadLocalRandom.current().nextInt(2);
        System.out.println(i);
        if (i > 0) {
            timeout();
        }
        return "重试调用成功";
    }
}
