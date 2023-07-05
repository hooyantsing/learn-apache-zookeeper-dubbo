package xyz.hooy.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.consumer.service.FlowControlService;

@RestController
@RequiredArgsConstructor
public class FlowControlRestController {

    private final FlowControlService flowControlService;

    @GetMapping("/timeout")
    public String testTimeout() {
        return flowControlService.timeout();
    }
}
