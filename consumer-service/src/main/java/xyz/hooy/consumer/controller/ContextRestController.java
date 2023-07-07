package xyz.hooy.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.consumer.service.ContextConsumerService;

@RestController
@RequiredArgsConstructor
public class ContextRestController {

    private final ContextConsumerService contextConsumerService;

    @GetMapping("/context")
    public String testContext() {
        return contextConsumerService.context();
    }
}
