package xyz.hooy.consumer.service;

public interface FlowControlConsumerService {

    String timeout();

    String retry();

    String conditionRoute();
}
