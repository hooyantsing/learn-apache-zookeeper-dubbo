package xyz.hooy.consumer.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.provider.api.dubbo.ProviderDubbo;

@RestController
@RequestMapping("/consumer")
public class ConsumerRestController {

    @DubboReference(group = "provider",version = "1.0")
    private ProviderDubbo providerDubbo;

    @GetMapping("/hello-world")
    public String testConsumerRestController(){
        return "hello world";
    }

    @Value("${spring.cloud.nacos.config.group}")
    private String configGroup;

    @GetMapping("/config-group")
    public String testConfigGroup(){
        return configGroup;
    }

    @GetMapping("/non-param")
    public String testNonParam(){
        return providerDubbo.nonParam();
    }
}
