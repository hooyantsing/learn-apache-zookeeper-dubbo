package xyz.hooy.consumer.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.consumer.api.dubbo.FlowControlConsumerDubbo;
import xyz.hooy.provider.api.dubbo.FlowControlProviderDubbo;

@Slf4j
@DubboService
public class FlowControlConsumerDubboImpl implements FlowControlConsumerDubbo {

    @DubboReference
    private FlowControlProviderDubbo flowControlProviderDubbo;

    @Override
    public String timeout() {
        String record = flowControlProviderDubbo.timeout();
        log.info(record);
        return record;
    }

    @Override
    public String retry() {
        String record = flowControlProviderDubbo.retry();
        log.info(record);
        return record;
    }

    @Override
    public String conditionRoute() {
        String record = flowControlProviderDubbo.conditionRoute();
        log.info(record);
        return record;
    }
}
