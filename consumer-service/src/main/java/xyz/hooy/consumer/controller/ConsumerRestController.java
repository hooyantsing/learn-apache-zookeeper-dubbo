package xyz.hooy.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import xyz.hooy.consumer.service.ParameterConsumerService;
import xyz.hooy.provider.api.model.Phone;

@RestController
@RequiredArgsConstructor
@RequestMapping("/consumer")
public class ConsumerRestController {

    private final ParameterConsumerService parameterConsumerService;

    @GetMapping("/hello-world")
    public String testConsumerRestController() {
        return "hello world";
    }

    @GetMapping("/non-param")
    public String testNonParam() {
        return parameterConsumerService.nonParam();
    }

    @GetMapping("/body-model")
    public Phone testBodyModel() {
        return parameterConsumerService.bodyModel();
    }
}
