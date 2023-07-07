package xyz.hooy.shenyu.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shenyu.client.dubbo.common.annotation.ShenyuDubboClient;
import xyz.hooy.consumer.api.dubbo.FlowControlConsumerDubbo;

@ShenyuDubboClient("/flow-control")
public class FlowControlRestController {

    @DubboReference
    private FlowControlConsumerDubbo flowControlConsumerDubbo;

    @ShenyuDubboClient("/timeout")
    public String testTimeout() {
        return flowControlConsumerDubbo.timeout();
    }

    @ShenyuDubboClient("/retry")
    public String testRetry() {
        return flowControlConsumerDubbo.retry();
    }

    @ShenyuDubboClient("/condition-route")
    public String testConditionRoute() {
        return flowControlConsumerDubbo.conditionRoute();
    }
}
