package xyz.hooy.consumer.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.consumer.api.dubbo.ParameterConsumerDubbo;
import xyz.hooy.provider.api.dubbo.ParameterProviderDubbo;
import xyz.hooy.provider.api.model.Phone;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@DubboService
public class ParameterConsumerDubboImpl implements ParameterConsumerDubbo {

    @DubboReference
    private ParameterProviderDubbo parameterProviderDubbo;

    @Override
    public String nonParam() {
        String record = parameterProviderDubbo.nonParam();
        log.info(record);
        return record;
    }

    @Override
    public Map<String, String> bodyModel() {
        Phone phone = parameterProviderDubbo.bodyModel();
        log.info(phone.toString());
        Map<String, String> record = new HashMap<>();
        record.put(phone.getName(), phone.getType());
        return record;
    }
}
