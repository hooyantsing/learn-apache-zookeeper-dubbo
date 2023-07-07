package xyz.hooy.consumer.api.dubbo;

public interface SyncAsyncConsumerDubbo {

    /**
     * 消费者同步-生产者同步
     */
    void syncSync();

    /**
     * 消费者同步-生产者异步
     */
    void syncAsync();

    /**
     * 消费者异步-生产者同步
     */
    void asyncSync();

    /**
     * 消费者异步-生产者异步
     */
    void asyncAsync();
}
