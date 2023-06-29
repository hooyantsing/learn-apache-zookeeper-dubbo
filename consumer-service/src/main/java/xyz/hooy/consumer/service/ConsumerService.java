package xyz.hooy.consumer.service;

import xyz.hooy.provider.api.model.Phone;

public interface ConsumerService {

    String configGroup();

    String nonParam();

    Phone bodyModel();
}
