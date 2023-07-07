package xyz.hooy.consumer.service;

public interface SyncAsyncConsumerService {

    /**
     * 消费者同步-生产者同步
     */
    public void syncSync();

    /**
     * 消费者同步-生产者异步
     */
    public void syncAsync();

    /**
     * 消费者异步-生产者同步
     */
    public void asyncSync();

    /**
     * 消费者异步-生产者异步
     */
    public void asyncAsync();
}
