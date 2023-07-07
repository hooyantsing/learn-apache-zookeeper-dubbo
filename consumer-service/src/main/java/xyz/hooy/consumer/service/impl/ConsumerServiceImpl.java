package xyz.hooy.consumer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.consumer.service.ConsumerService;
import xyz.hooy.provider.api.dubbo.ProviderDubbo;
import xyz.hooy.provider.api.model.Phone;

@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @DubboReference
    private ProviderDubbo providerDubbo;

    @Override
    public String nonParam() {
        String record = providerDubbo.nonParam();
        log.info(record);
        return record;
    }

    @Override
    public Phone bodyModel() {
        Phone record = providerDubbo.bodyModel();
        log.info(record.toString());
        return record;
    }
}
