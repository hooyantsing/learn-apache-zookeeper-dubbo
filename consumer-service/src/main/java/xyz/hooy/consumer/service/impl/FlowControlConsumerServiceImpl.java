package xyz.hooy.consumer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.consumer.service.FlowControlConsumerService;
import xyz.hooy.provider.api.dubbo.FlowControlProviderDubbo;

@Slf4j
@Service
public class FlowControlConsumerServiceImpl implements FlowControlConsumerService {

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
