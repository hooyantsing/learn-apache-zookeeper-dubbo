package xyz.hooy.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.consumer.service.FlowControlConsumerService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/flow-control")
public class FlowControlRestController {

    private final FlowControlConsumerService flowControlConsumerService;

    @GetMapping("/timeout")
    public String testTimeout() {
        return flowControlConsumerService.timeout();
    }

    @GetMapping("/retry")
    public String testRetry() {
        return flowControlConsumerService.retry();
    }

    @GetMapping("/condition-route")
    public String testConditionRoute() {
        return flowControlConsumerService.conditionRoute();
    }
}
