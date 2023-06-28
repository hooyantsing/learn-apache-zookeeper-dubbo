package xyz.hooy.provider.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.provider.api.dubbo.ProviderDubbo;
import xyz.hooy.provider.api.model.Phone;

@DubboService(group = "provider", version = "1.0")
public class ProviderDubboImpl implements ProviderDubbo {

    @Override
    public String nonParam() {
        return "hello dubbo";
    }

    @Override
    public Phone bodyModel() {
        return new Phone("iPhone 5s", "A1528");
    }
}
