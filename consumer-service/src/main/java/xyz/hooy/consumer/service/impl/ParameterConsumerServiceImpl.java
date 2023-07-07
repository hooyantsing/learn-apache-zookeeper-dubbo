package xyz.hooy.consumer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.consumer.service.ParameterConsumerService;
import xyz.hooy.provider.api.dubbo.ParameterProviderDubbo;
import xyz.hooy.provider.api.model.Phone;

@Slf4j
@Service
public class ParameterConsumerServiceImpl implements ParameterConsumerService {

    @DubboReference
    private ParameterProviderDubbo parameterProviderDubbo;

    @Override
    public String nonParam() {
        String record = parameterProviderDubbo.nonParam();
        log.info(record);
        return record;
    }

    @Override
    public Phone bodyModel() {
        Phone record = parameterProviderDubbo.bodyModel();
        log.info(record.toString());
        return record;
    }
}
