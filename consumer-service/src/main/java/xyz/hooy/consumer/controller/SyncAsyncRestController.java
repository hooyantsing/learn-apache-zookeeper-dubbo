package xyz.hooy.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.consumer.service.SyncAsyncConsumerService;

@RestController
@RequiredArgsConstructor
public class SyncAsyncRestController {

    private final SyncAsyncConsumerService syncAsyncConsumerService;

    @GetMapping("/syncAsync")
    public void testSyncAsync(){
        syncAsyncConsumerService.syncSync();
        syncAsyncConsumerService.syncAsync();
        syncAsyncConsumerService.asyncSync();
        syncAsyncConsumerService.asyncAsync();
    }
}
