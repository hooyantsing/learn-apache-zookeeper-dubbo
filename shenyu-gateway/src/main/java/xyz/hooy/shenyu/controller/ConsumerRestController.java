package xyz.hooy.shenyu.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shenyu.client.dubbo.common.annotation.ShenyuDubboClient;
import org.springframework.stereotype.Controller;
import xyz.hooy.consumer.api.dubbo.ParameterConsumerDubbo;

import java.util.Map;

@Controller
@ShenyuDubboClient("/consumer")
public class ConsumerRestController {

    @DubboReference
    private ParameterConsumerDubbo parameterConsumerDubbo;

    @ShenyuDubboClient("/hello-world")
    public String testConsumerRestController() {
        return "hello world";
    }

    @ShenyuDubboClient("/non-param")
    public String testNonParam() {
        return parameterConsumerDubbo.nonParam();
    }

    @ShenyuDubboClient("/body-model")
    public Map<String, String> testBodyModel() {
        return parameterConsumerDubbo.bodyModel();
    }
}
