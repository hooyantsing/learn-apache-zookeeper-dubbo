package xyz.hooy.provider.dubbo;

import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.provider.api.dubbo.SyncAsyncDubbo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@DubboService(group = "syncAsyncDubboImpl", version = "1.0")
public class SyncAsyncDubboImpl implements SyncAsyncDubbo {

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