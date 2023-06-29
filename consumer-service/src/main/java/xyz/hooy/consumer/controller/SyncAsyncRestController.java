package xyz.hooy.consumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.hooy.consumer.service.SyncAsyncService;

@RestController
@RequiredArgsConstructor
public class SyncAsyncRestController {

    private final SyncAsyncService syncAsyncService;

    @GetMapping("/syncAsync")
    public void testSyncAsync(){
        syncAsyncService.syncSync();
        syncAsyncService.syncAsync();
        syncAsyncService.asyncSync();
        syncAsyncService.asyncAsync();
    }
}
