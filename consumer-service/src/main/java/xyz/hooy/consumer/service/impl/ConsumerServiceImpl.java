package xyz.hooy.consumer.service.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import xyz.hooy.consumer.service.ConsumerService;
import xyz.hooy.provider.api.dubbo.ProviderDubbo;
import xyz.hooy.provider.api.model.Phone;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @DubboReference(group = "providerDubboImpl", version = "1.0")
    private ProviderDubbo providerDubbo;

    @Value("${spring.cloud.nacos.config.group}")
    private String configGroup;

    @Override
    public String configGroup() {
        return configGroup;
    }

    @Override
    public String nonParam() {
        return providerDubbo.nonParam();
    }

    @Override
    public Phone bodyModel() {
        return providerDubbo.bodyModel();
    }
}
