package xyz.hooy.provider.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.provider.api.dubbo.ParameterProviderDubbo;
import xyz.hooy.provider.api.model.Phone;

@DubboService
public class ParameterProviderDubboImpl implements ParameterProviderDubbo {

    @Override
    public String nonParam() {
        return "无参调用成功";
    }

    @Override
    public Phone bodyModel() {
        return new Phone("JavaBean 调用", "成功");
    }
}
