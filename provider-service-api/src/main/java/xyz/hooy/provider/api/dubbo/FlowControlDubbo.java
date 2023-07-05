package xyz.hooy.provider.api.dubbo;

public interface FlowControlDubbo {

    /**
     * DubboAdmin -> 服务治理 -> 动态配置
     * 配置：
     * -------------------------------
     * configVersion: v3.0
     * enabled: true
     * configs:
     *   - side: provider
     *     parameters:
     *       timeout: 2000
     * -------------------------------
     */
    String timeout();

    /**
     * DubboAdmin -> 服务治理 -> 动态配置
     * 配置：
     * -------------------------------
     * configVersion: v3.0
     * enabled: true
     * configs:
     *   - side: consumer
     *     parameters:
     *       retries: 5
     * -------------------------------
     */
    String retry();
}
