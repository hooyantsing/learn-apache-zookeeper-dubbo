package xyz.hooy.consumer.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.consumer.service.FlowControlService;
import xyz.hooy.provider.api.dubbo.FlowControlDubbo;

@Service
public class FlowControlServiceImpl implements FlowControlService {

    @DubboReference
    private FlowControlDubbo flowControlDubbo;

    @Override
    public String timeout() {
        return flowControlDubbo.timeout();
    }
}
