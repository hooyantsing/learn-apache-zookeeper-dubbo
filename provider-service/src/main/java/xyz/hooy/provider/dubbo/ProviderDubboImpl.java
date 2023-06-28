package xyz.hooy.provider.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.provider.api.dubbo.ProviderDubbo;

@DubboService(group = "provider",version = "1.0")
public class ProviderDubboImpl implements ProviderDubbo {

    @Override
    public String nonParam() {
        return "hello dubbo";
    }
}
