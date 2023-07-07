package xyz.hooy.shenyu.controller;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shenyu.client.dubbo.common.annotation.ShenyuDubboClient;
import xyz.hooy.consumer.api.dubbo.SyncAsyncConsumerDubbo;

public class SyncAsyncRestController {

    @DubboReference
    private SyncAsyncConsumerDubbo syncAsyncConsumerDubbo;

    @ShenyuDubboClient("/syncAsync")
    public void testSyncAsync(){
        syncAsyncConsumerDubbo.syncSync();
        syncAsyncConsumerDubbo.syncAsync();
        syncAsyncConsumerDubbo.asyncSync();
        syncAsyncConsumerDubbo.asyncAsync();
    }
}
