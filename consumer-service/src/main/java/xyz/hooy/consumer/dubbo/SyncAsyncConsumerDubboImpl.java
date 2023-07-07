package xyz.hooy.consumer.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import xyz.hooy.consumer.api.dubbo.SyncAsyncConsumerDubbo;
import xyz.hooy.provider.api.dubbo.SyncAsyncProviderDubbo;

import java.util.concurrent.CompletableFuture;

@Slf4j
@DubboService
public class SyncAsyncConsumerDubboImpl implements SyncAsyncConsumerDubbo {

    @DubboReference(group = "syncAsyncDubboImpl", version = "1.0")
    private SyncAsyncProviderDubbo syncAsyncProviderDubbo;

    @Override
    public void syncSync() {
        String v = syncAsyncProviderDubbo.syncInvoke("hooy");
        log.info("syncSync: {}", v);
    }

    @Override
    public void syncAsync() {
        CompletableFuture<String> future = syncAsyncProviderDubbo.asyncInvoke("hooy");
        future.whenComplete((v, t) -> {
            if (t == null) {
                log.info("syncAsync: {}", v);
            } else {
                log.error("", t);
            }
        });
    }

    @Override
    public void asyncSync() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> syncAsyncProviderDubbo.syncInvoke("hooy"));
        future.whenComplete((v, t) -> {
            if (t == null) {
                log.info("asyncSync: {}", v);
            } else {
                log.error("", t);
            }
        });
    }

    @Override
    public void asyncAsync() {
        CompletableFuture<CompletableFuture<String>> future = CompletableFuture.supplyAsync(() -> syncAsyncProviderDubbo.asyncInvoke("hooy"));
        future.whenComplete((v, t) -> {
            if (t == null) {
                v.whenComplete((value, throwable) -> {
                    if (throwable == null) {
                        log.info("asyncAsync: {}", value);
                    } else {
                        log.error("", throwable);
                    }
                });
            } else {
                log.error("", t);
            }
        });
    }
}
