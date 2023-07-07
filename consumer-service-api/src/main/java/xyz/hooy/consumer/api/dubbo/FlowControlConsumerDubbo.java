package xyz.hooy.consumer.api.dubbo;

public interface FlowControlConsumerDubbo {

    String timeout();

    String retry();

    String conditionRoute();
}
