package org.kangspace.wechat.helper.core.config;


/**
 * Redis配置工厂类
 * @author kango2gler@gmail.com
 * @since 2022/12/17
 */
public class WeChatRedisConfigFactory {

    /**
     * 获取新配置
     * @param serverType redis服务类型, {@link WeChatRedisConfig.ServerType}
     * @param address Redis地址
     * @param username 用户名
     * @param passport 密码
     * @param database 数据库
     * @return {@link WeChatRedisConfig}
     * @see WeChatRedisConfig.ServerType
     */
    public static WeChatRedisConfig newConfig(WeChatRedisConfig.ServerType serverType, String address, String username, String passport, Integer database) {
        WeChatRedisConfig config = new WeChatRedisConfig(address);
        return config.setServerType(serverType).setUsername(username).setPassword(passport).setDatabase(database);
    }

    /**
     * 获取新配置
     * @param serverType redis服务类型, {@link WeChatRedisConfig.ServerType}
     * @param address Redis地址
     * @param database 数据库
     * @return {@link WeChatRedisConfig}
     * @see WeChatRedisConfig.ServerType
     */
    public static WeChatRedisConfig newConfig(WeChatRedisConfig.ServerType serverType, String address, Integer database) {
        WeChatRedisConfig config = new WeChatRedisConfig(address);
        return config.setServerType(serverType).setDatabase(database);
    }
}
