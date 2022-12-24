package org.kangspace.wechat.helper.core.storage.redis;

import org.kangspace.wechat.helper.core.config.WeChatRedisConfig;
import org.kangspace.wechat.helper.core.constant.StringLiteral;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Redisson工厂O
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/17
 */
public class RedissonClientFactory {

    /**
     * 创建新的Redisson对象
     *
     * @param redisConfig {@link WeChatRedisConfig}
     * @return {@link Redisson}
     */
    public static RedissonClient newRedisson(WeChatRedisConfig redisConfig) {
        Objects.requireNonNull(redisConfig, "redisConfig must be not null!");
        Config config = new Config();
        WeChatRedisConfig.ServerType serverType = redisConfig.getServerType();
        BaseConfig serverConfig = serverType.getServerConfigFunction().apply(config);
        serverConfig.setConnectTimeout(redisConfig.getConnectTimeout());
        serverConfig.setIdleConnectionTimeout(redisConfig.getIdleConnectionTimeout());
        serverConfig.setTimeout(redisConfig.getTimeout());
        serverConfig.setRetryAttempts(redisConfig.getRetryAttempts());
        serverConfig.setRetryInterval(redisConfig.getRetryInterval());
        serverConfig.setUsername(redisConfig.getUsername());
        serverConfig.setPassword(redisConfig.getPassword());
        String address = redisConfig.getAddress();
        String[] addressArr = address.split(StringLiteral.COMMA);
        Integer database = redisConfig.getDatabase();
        int connectionPoolSize = redisConfig.getConnectionPoolSize();
        int connectionMinimumIdleSize = redisConfig.getConnectionMinimumIdleSize();
        // 公共主从Server配置
        Consumer<BaseConfig> commonMasterSlaveServersConfig = (t) -> ((MasterSlaveServersConfig) t)
                .setMasterConnectionPoolSize(connectionPoolSize)
                .setSlaveConnectionPoolSize(connectionPoolSize)
                .setMasterConnectionMinimumIdleSize(connectionMinimumIdleSize)
                .setSlaveConnectionMinimumIdleSize(connectionMinimumIdleSize);
        // 带有DataBase的主从Server配置
        Consumer<BaseConfig> commonMasterSlaveServersConfigWithDataBase = (t) -> {
            ((MasterSlaveServersConfig) t).setDatabase(database);
            commonMasterSlaveServersConfig.accept(t);
        };
        switch (serverType) {
            case SingleServer:
                ((SingleServerConfig) serverConfig)
                        .setConnectionPoolSize(connectionPoolSize)
                        .setConnectionMinimumIdleSize(connectionMinimumIdleSize)
                        .setAddress(address)
                        .setDatabase(database);
                break;
            case ClusterServers:
                ((ClusterServersConfig) serverConfig).addNodeAddress(addressArr);
                commonMasterSlaveServersConfig.accept(serverConfig);
                break;
            case MasterSlaveServers:
                String masterAddress = addressArr[0];
                String[] slaveAddressArr = addressArr.length > 1 ? Arrays.copyOfRange(addressArr, 1, addressArr.length - 1) : null;
                ((MasterSlaveServersConfig) serverConfig).setMasterAddress(masterAddress);
                if (slaveAddressArr != null) {
                    ((MasterSlaveServersConfig) serverConfig).addSlaveAddress(slaveAddressArr);
                }
                commonMasterSlaveServersConfigWithDataBase.accept(serverConfig);
                break;
            case SentinelServers:
                ((SentinelServersConfig) serverConfig).addSentinelAddress(addressArr);
                commonMasterSlaveServersConfigWithDataBase.accept(serverConfig);
                break;
            case ReplicatedServers:
                ((ReplicatedServersConfig) serverConfig).addNodeAddress(addressArr);
                commonMasterSlaveServersConfigWithDataBase.accept(serverConfig);
                break;
            default:
                throw new IllegalStateException("serverType:" + serverType + " is not supported!!");
        }
        return Redisson.create(config);
    }
}
