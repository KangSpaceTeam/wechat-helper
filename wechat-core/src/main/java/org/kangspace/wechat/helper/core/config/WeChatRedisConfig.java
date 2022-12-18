package org.kangspace.wechat.helper.core.config;

import lombok.Data;
import lombok.experimental.Accessors;
import org.redisson.config.BaseConfig;
import org.redisson.config.Config;

import javax.annotation.Nonnull;
import java.util.function.Function;

/**
 * Redis配置
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/17
 * @see WeChatRedisConfigFactory
 */
@Data
@Accessors(chain = true)
public class WeChatRedisConfig {
    /**
     * redis地址,多个按","分割<br>
     * 地址需要包含协议: redis:// 或 rediss://<br>
     * master地址在在前。
     */
    @Nonnull
    private String address;
    /**
     * 数据库
     */
    private Integer database = 0;
    /**
     * Server类型
     */
    private ServerType serverType = ServerType.SingleServer;
    /**
     * 连接最小空闲数
     */
    private int connectionMinimumIdleSize = 24;
    /**
     * 连接池数
     */
    private int connectionPoolSize = 64;
    /**
     * 空闲连接超时时间
     */
    private int idleConnectionTimeout = 10000;
    /**
     * 连接超时时间
     */
    private int connectTimeout = 10000;
    /**
     * 超时时间
     */
    private int timeout = 3000;
    /**
     * 重试次数
     */
    private int retryAttempts = 3;
    /**
     * 重试间隔,单位: 毫秒
     */
    private int retryInterval = 1500;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;

    /**
     * Server类型
     */
    public enum ServerType {
        /**
         * 单机Server
         */
        SingleServer((config) -> config.useSingleServer()),
        /**
         * 分片集群Server
         */
        ClusterServers((config) -> config.useClusterServers()),
        /**
         * 主从Server
         */
        MasterSlaveServers((config) -> config.useMasterSlaveServers()),
        /**
         * 哨兵Server
         */
        SentinelServers((config) -> config.useSentinelServers()),
        /**
         * 副本Server
         */
        ReplicatedServers((config) -> config.useReplicatedServers());

        private final Function<Config, BaseConfig> serverConfigFunction;

        ServerType(Function<Config, BaseConfig> serverConfigSupplier) {
            this.serverConfigFunction = serverConfigSupplier;
        }

        public Function<Config, BaseConfig> getServerConfigFunction() {
            return serverConfigFunction;
        }
    }
}
