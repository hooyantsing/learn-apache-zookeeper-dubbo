package xyz.hooy.consumer.service;

import xyz.hooy.provider.api.model.Phone;

public interface ParameterConsumerService {

    String nonParam();

    Phone bodyModel();
}
