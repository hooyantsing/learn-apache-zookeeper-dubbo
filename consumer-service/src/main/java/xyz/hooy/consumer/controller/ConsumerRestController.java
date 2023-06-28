package xyz.hooy.consumer.controller;

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
}
