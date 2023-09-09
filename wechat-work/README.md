# wechat-works 企微微信模块
<!-- TOC -->
* [wechat-works 企微微信模块](#wechat-works-企微微信模块)
    * [1.1 基本用法](#11-基本用法)
  * [2. AccessToken 说明](#2-accesstoken-说明)
    * [2.1 access_token获取](#21-accesstoken获取)
    * [2.2 access_token刷新](#22-accesstoken刷新)
    * [2.3 access_token缓存](#23-accesstoken缓存)
  * [3. 接口扩展](#3-接口扩展)
  * [4. 消息和事件](#4-消息和事件)
    * [4.1 消息](#41-消息)
    * [4.2 事件](#42-事件)
  * [附录](#附录)
    * [A. 企业微信官方文档](#a-企业微信官方文档)
<!-- TOC -->



**企业微信接入模块**

| 企业微信模块  <div style="width: 170px"/> | 接入状态 <div style="width: 40px"/> | 实现类  <div style="width: 150px"/>                                                                     | 用法         <div style="width: 100px"/>                                                                           | 
|-------------------------------------|---------------------------------|------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------|
| 获取企微微信服务器IP地址                       | ✅                               | `WeComServerService`                                                                                 | [ServerServiceTest](src/test/java/org/kangspace/wechat/helper/work/WeComServerServiceTest.java)                  |
| 基础 ↓                                |                                 |                                                                                                      |                                                                                                                  |
| 帐号ID                                | ✅                               | `WeComIDService`                                                                                     | [WeComIDServiceTest](src/test/java/org/kangspace/wechat/helper/work/WeComIDServiceTest.java)                     |
| 通讯录管理-成员管理                          | ✅                               | `UserService`                                                                                        | [UserServiceTest](src/test/java/org/kangspace/wechat/helper/work/UserServiceTest.java)                           |
| 通讯录管理-部门管理                          | ✅                               | `DepartmentService`                                                                                  | [DepartmentServiceTest](src/test/java/org/kangspace/wechat/helper/work/DepartmentServiceTest.java)               |
| 通讯录管理-标签管理                          | ✅                               | `TagService`                                                                                         | [TagServiceTest](src/test/java/org/kangspace/wechat/helper/work/TagServiceTest.java)                             |
| 通讯录管理-互联企业                          | ✅                               | `LinkedCorpService`                                                                                  | [LinkedCorpServiceTest](src/test/java/org/kangspace/wechat/helper/work/LinkedCorpServiceTest.java)               |
| 消息通知                                | ✅                               | `WeComMessageHandler/`<br/>`WeComMessageResolver`,<br/>`WeComEventHandler/`<br/>`WeComEventResolver` | [WeComMessageResolverTest](src/test/java/org/kangspace/wechat/helper/work/message/WeComMessageResolverTest.java) |
| 身份验证                                | ✅                               | `AuthService`                                                                                        | [AuthServiceTest](src/test/java/org/kangspace/wechat/helper/work/AuthServiceTest.java)                           |
| 企业互联                                | ✅                               | `CorpGroupService`                                                                                   | [CorpGroupServiceTest](src/test/java/org/kangspace/wechat/helper/work/CorpGroupServiceTest.java)                 |
| 安全管理                                | ✅                               | `SecurityService`                                                                                    | [SecurityServiceTest](src/test/java/org/kangspace/wechat/helper/work/SecurityServiceTest.java)                   |
| 消息推送-应用发送消息到群聊会话                    | ✅                               | `AppChatService`                                                                                     | [AppChatServiceTest](src/test/java/org/kangspace/wechat/helper/work/AppChatServiceTest.java)                     |
| 群机器人                                | ✅                               | `WebHookService`                                                                                     | [WebHookServiceTest](src/test/java/org/kangspace/wechat/helper/work/WebHookServiceTest.java)                     |
| 应用管理                                | ✅                               | `AgentService`                                                                                       | [AgentServiceTest](src/test/java/org/kangspace/wechat/helper/work/AgentServiceTest.java)                         |
| 应用管理-自定义菜单                          | ✅                               | `MenuService`                                                                                        | [MenuServiceTest](src/test/java/org/kangspace/wechat/helper/work/MenuServiceTest.java)                           |
| 素材管理                                |                                 | `MediaService`                                                                                       | [MediaServiceTest](src/test/java/org/kangspace/wechat/helper/work/MediaServiceTest.java)                         |

> Service名称一般取自 API 第一个URL目录, 如
>
> URL: https://qyapi.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&userid=USERID
>
> Service: UserService

### 1.1 基本用法

1. **创建Service对象**

所有Service接口的的默认实现都是以DefaultXXXX开头的。如`WeComServerService的实现类为DefaultWeComServerService`

```
  String corpId = "", corpSecret = "";
  WeComConfig WeComConfig = new WeComConfig(corpId, corpSecret);
  DefaultWeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(WeComConfig);
  WeComServerService weComServerService = new DefaultWeComServerService(weComAccessTokenService);
```

2. **通过Service A实例获取Service B的实例**

如通过`WeComServerService`获取`UserService`实例

- **方式一: 直接通过`ofXXXX`获取对应Service**

```
UserService openApiService  = weComServerService.ofUserService();
```

- **方式二: 通过`<T extends WeChatService> T of(Class<T> toWeChatService)`获取对应Service**

`toWeChatService`为对应Service的实现类, 一般为`DefaultXXXService`

```
UserService openApiService  = weComServerService.of(DefaultUserService.class);
```

## 2. AccessToken 说明

// TODO xxx

AccessToken无需单独获取和指定，调用Api方法时，会自动获取并缓存AccessToken.
AccessToken由`WeComAccessTokenService`维护，且缓存由`WeChatTokenStorage`维护。

### 2.1 access_token获取

- **方式一: 使用`WeComAccessTokenService`获取token**

```
String appId = "", appSecret = "";
WeComConfig weComConfig = new WeComConfig(appId, appSecret);
WeComAccessTokenService WeComAccessTokenService = new DefaultWeComAccessTokenService(weComConfig);
String token = WeComAccessTokenService.getToken();
```

- **方式二: 使用Service实例获取token**

```
String token = weComService.getToken();
```

### 2.2 access_token刷新

- **方式一: 自动刷新**

调用Api方法时，若收到微信`40014:不合法的 access_token ，请开发者认真比对 access_token 的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口`
时,会自动重新请求AccessToken。

- **方式二: 通过`WeComAccessTokenService`刷新AccessToken**

刷新后会自动更新到缓存中。

```
weComAccessTokenService.tokenRefresh()
# 或
weComAccessTokenService.token(true)
```

### 2.3 access_token缓存

AccessToken缓存由`WeChatTokenStorage`维护，默认实现为`DefaultLocalWeChatTokenStorage`。
可在实例化`WeComConfig`时指定`WeChatTokenStorage`。

1. **默认缓存`DefaultLocalWeChatTokenStorage`**

AccessToken缓存在当前Jvm中。

```
WeComConfig WeComConfig = new WeComConfig(appId, appSecret);
WeComAccessTokenService weComAccessTokenService = new DefaultWeComAccessTokenService(WeComConfig);
```

2. **指定`WeChatTokenStorage`实现类**

指定为Redis缓存实现类。

```
String redisAddress = "redis://127.0.0.1:6379";
Integer database = 0;

WeComConfig weComConfigWithRedis = new WeComConfig(appId, appSecret);
weComConfigWithRedis.setRedisConfig(WeChatRedisConfigFactory.newConfig(WeChatRedisConfig.ServerType.SingleServer, redisAddress, database));
RedisWeChatTokenStorage mpServerServiceWithRedisStorage = new RedisWeChatTokenStorage(WeComConfigWithRedis);
weComConfigWithRedis.setWeChatTokenStorage(mpServerServiceWithRedisStorage);
weComAccessTokenService = new DefaultWeComAccessTokenService(WeComConfigWithRedis);
```

## 3. 接口扩展

可通过继承`AbstractWeComService`类来快速接入微信公众号API, 并使用其中的`post`,`get`方法。
调用`post`,`get`方法时，可以指定是否需要AccessToken。

如:

```
public class DefaultWeComServerService extends AbstractWeComService implements WeComServerService {

    public DefaultWeComServerService(WeComConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultWeComServerService(WeComAccessTokenService weComAccessTokenService) {
        super(weComAccessTokenService);
    }

    public DefaultWeComServerService(WeComAccessTokenService weComAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weComAccessTokenService, requestFilterChain);
    }
}
```

## 4. 消息和事件
消息和事件 由 `WeComMessageResolver` 处理, 需先创建 `WeComMessageResolver`实例, 实现”消息处理器`WeComMessageHandler<?>`“、”事件处理器`WeComEventHandler<?> `“,
并将处理器添加到`WeComMessageResolver`中。

> 可参见[wechat-platform/WeComServiceConfig.java](../wechat-platform/src/main/java/org/kangspace/wechat/helper/platform/config/WeComServiceConfig.java)

*创建`WeComMessageResolver`并添加消息处理器*
```java
@Resource
private List<WeComMessageHandler<WeComMessage>> messageHandlers;
    
WeComMessageResolver weComMessageResolver = new WeComMessageResolver(weComService);
weComMessageResolver.addWeChatHandlers(messageHandlers);
```

### 4.1 消息
实现`WeComMessageHandler<?>`消息处理器, 并重写handle方法, `?`为需要处理的具体消息类型。

> 可参见[wechat-platform/MessageHandler.java](../wechat-platform/src/main/java/org/kangspace/wechat/helper/platform/message/wecom/MessageHandler.java)

```
@Component("weComMessageHandler")
@Slf4j
public class MessageHandler implements WeComMessageHandler<WeComMessage> {
    @Override
    public WeComEchoMessage handle(WeComService service, WeComMessage message, MessageResolverContext context) {
        log.info("企业微信消息解析器: message: {}, context: {}", message, context);
        return WeComMessageHandler.super.handle(service, message, context);
    }
}
```

### 4.2 事件
实现`WeComEventHandler<?>`消息处理器, 并重写handle方法, `?`为需要处理的具体事件类型。

> 可参见[wechat-platform/EventHandler.java](../wechat-platform/src/main/java/org/kangspace/wechat/helper/platform/message/wecom/EventHandler.java)

```java
@Component("weComEventHandler")
@Slf4j
public class EventHandler implements WeComEventHandler<WeComXmlEvent> {
    @Override
    public WeComEchoMessage handle(WeComService service, WeComXmlEvent event, MessageResolverContext context) {
        log.info("企业微信事件解析器: message: {}, context: {}", event, context);
        return WeComEventHandler.super.handle(service, event, context);
    }

}
```

## 附录

### A. 企业微信官方文档
企业内部开发-服务端： https://developer.work.weixin.qq.com/document/path/90664
