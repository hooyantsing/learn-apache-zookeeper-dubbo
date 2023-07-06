package xyz.hooy.consumer.service;

public interface FlowControlService {

    String timeout();

    String retry();

    String conditionRoute();
}
