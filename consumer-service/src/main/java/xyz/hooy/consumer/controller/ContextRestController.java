package xyz.hooy.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.consumer.service.ContextService;

@RestController
@RequiredArgsConstructor
public class ContextRestController {

    private final ContextService contextService;

    @GetMapping("/context")
    public String testContext() {
        return contextService.context();
    }
}
