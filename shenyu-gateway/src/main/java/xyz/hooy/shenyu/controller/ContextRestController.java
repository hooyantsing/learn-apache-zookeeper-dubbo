package xyz.hooy.shenyu.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shenyu.client.dubbo.common.annotation.ShenyuDubboClient;
import xyz.hooy.consumer.api.dubbo.ContextConsumerDubbo;

public class ContextRestController {

    @DubboReference
    private ContextConsumerDubbo contextConsumerDubbo;

    @ShenyuDubboClient("/context")
    public String testContext() {
        return contextConsumerDubbo.context();
    }
}
