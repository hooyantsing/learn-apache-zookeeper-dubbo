package xyz.hooy.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerRestController {

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
}
