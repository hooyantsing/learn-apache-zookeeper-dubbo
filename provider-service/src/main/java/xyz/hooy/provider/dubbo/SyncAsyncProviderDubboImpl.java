package xyz.hooy.provider.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.provider.api.dubbo.SyncAsyncProviderDubbo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@DubboService(group = "syncAsyncDubboImpl", version = "1.0")
public class SyncAsyncProviderDubboImpl implements SyncAsyncProviderDubbo {

    @Override
    public String syncInvoke(String param) {
        try {
            long time = ThreadLocalRandom.current().nextLong(1000);
            Thread.sleep(time);
            StringBuilder s = new StringBuilder();
            s.append("AsyncService invoke param:").append(param).append(",sleep:").append(time);
            return s.toString();
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

    /**
     * 避免 dubbo 线程被阻塞，可以使用异步将线程切换到业务线程
     */
    @Override
    public CompletableFuture<String> asyncInvoke(String param) {
        // 建议为supplyAsync提供自定义线程池
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Do something
                long time = ThreadLocalRandom.current().nextLong(1000);
                Thread.sleep(time);
                StringBuilder s = new StringBuilder();
                s.append("AsyncService asyncInvoke param:").append(param).append(",sleep:").append(time);
                return s.toString();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return null;
        });
    }
}