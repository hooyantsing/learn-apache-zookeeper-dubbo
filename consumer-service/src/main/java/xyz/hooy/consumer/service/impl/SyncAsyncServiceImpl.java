package xyz.hooy.consumer.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import xyz.hooy.consumer.service.SyncAsyncService;
import xyz.hooy.provider.api.dubbo.SyncAsyncDubbo;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class SyncAsyncServiceImpl implements SyncAsyncService {

    @DubboReference(group = "syncAsyncDubboImpl", version = "1.0")
    private SyncAsyncDubbo syncAsyncDubbo;

    @Override
    public void syncSync() {
        String v = syncAsyncDubbo.syncInvoke("hooy");
        log.info("syncSync: {}", v);
    }

    @Override
    public void syncAsync() {
        CompletableFuture<String> future = syncAsyncDubbo.asyncInvoke("hooy");
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
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> syncAsyncDubbo.syncInvoke("hooy"));
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
        CompletableFuture<CompletableFuture<String>> future = CompletableFuture.supplyAsync(() -> syncAsyncDubbo.asyncInvoke("hooy"));
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
