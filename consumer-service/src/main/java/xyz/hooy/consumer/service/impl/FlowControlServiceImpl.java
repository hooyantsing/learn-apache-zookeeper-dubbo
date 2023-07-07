package xyz.hooy.consumer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.consumer.service.FlowControlService;
import xyz.hooy.provider.api.dubbo.FlowControlDubbo;

@Slf4j
@Service
public class FlowControlServiceImpl implements FlowControlService {

    @DubboReference
    private FlowControlDubbo flowControlDubbo;

    @Override
    public String timeout() {
        String record = flowControlDubbo.timeout();
        log.info(record);
        return record;
    }

    @Override
    public String retry() {
        String record = flowControlDubbo.retry();
        log.info(record);
        return record;
    }

    @Override
    public String conditionRoute() {
        String record = flowControlDubbo.conditionRoute();
        log.info(record);
        return record;
    }
}
