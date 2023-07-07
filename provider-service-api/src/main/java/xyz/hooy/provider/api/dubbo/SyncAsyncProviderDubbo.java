package xyz.hooy.provider.api.dubbo;

import java.util.concurrent.CompletableFuture;

public interface SyncAsyncProviderDubbo {

    /**
     * 同步调用方法
     */
    String syncInvoke(String param);
    /**
     * 异步调用方法
     */
    CompletableFuture<String> asyncInvoke(String param);
}
