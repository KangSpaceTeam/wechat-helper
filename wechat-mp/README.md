# wechat-mp 微信公众平台模块

<!-- TOC -->

* [wechat-mp 微信公众平台模块](#wechat-mp-)
    * [1. 用法](#1-)
        * [1.1 基本用法](#11-)
        * [1.2 通用接口](#12-)
            * [1. 获取AccessToken](#1-accesstoken)
            * [2. 获取微信服务器IP地址](#2-ip)
            * [3. 网络检测](#3-)
    * [2. AccessToken 说明](#2-accesstoken-)
    * [4. 接口扩展](#4-)
    * [5. 消息和事件](#5-)
        * [5.1 消息](#51-)
        * [5.2 事件](#52-)
    * [附录](#)
        * [A. 微信公众号官方文档](#a-)
            * [公众平台开发文档](#)
            * [公众平台更新日志](#)
            * [公众平台接入指南](#)
            * [微信公众平台接口测试帐号系统](#)
            * [微信公众平台接口调试工具](#)

<!-- TOC -->


**微信公众平台接入模块**

| 微信公众平台模块         | 接入状态 | 实现类                           | 用法                                                                                                             | 
|------------------|------|-------------------------------|----------------------------------------------------------------------------------------------------------------|
| 获取微信服务器IP地址、网络检测 | ✅    | `ServerService`               | [ServerServiceTest](src/test/java/org/kangspace/wechat/helper/mp/ServerServiceTest.java)                       |
| openApi管理        | ✅    | `OpenApiService`              | [OpenApiServiceTest](src/test/java/org/kangspace/wechat/helper/mp/OpenApiServiceTest.java)                     |
| 自定义菜单            | ✅    | `CustomMenusService`          | [CustomMenusServiceTest](src/test/java/org/kangspace/wechat/helper/mp/CustomMenusServiceTest.java)             |
| 基础消息能力           | ✅    | `MessageService`              | [MessageServiceTest](src/test/java/org/kangspace/wechat/helper/mp/MessageServiceTest.java)                     |
| 订阅通知             | ✅    | `SubscriptionMessagesService` | 同  [MessageServiceTest](src/test/java/org/kangspace/wechat/helper/mp/MessageServiceTest.java)                  |
| 微信网页开发           | ✅    | `WebAppsService`              | [WebAppsServiceTest](src/test/java/org/kangspace/wechat/helper/mp/WebAppsServiceTest.java)                     |
| 素材管理             | ✅    | `AssetService`                | [AssertServiceTest](src/test/java/org/kangspace/wechat/helper/mp/AssertServiceTest.java)                       |
| 用户管理             | ✅    | `UserManagementService`       | [UserManagementServiceTest](src/test/java/org/kangspace/wechat/helper/mp/UserManagementServiceTest.java)       |
| 账号管理             | ✅    | `AccountManagementService`    | [AccountManagementServiceTest](src/test/java/org/kangspace/wechat/helper/mp/AccountManagementServiceTest.java) |
| 客服消息             | ⛔    |                               |                                                                                                                |
| 草稿箱              | ⛔    |                               |                                                                                                                |
| 发布能力             | ⛔    |                               |                                                                                                                |
| 数据统计             | ⛔    |                               |                                                                                                                |
| 微信卡券             | ⛔    |                               |                                                                                                                |
| 微信门店             | ⛔    |                               |                                                                                                                |
| 微信小店             | ⛔    |                               |                                                                                                                |
| 智能接口             | ⛔    |                               |                                                                                                                |
| 微信设备功能           | ⛔    |                               |                                                                                                                |
| 微信"一物一码"         | ⛔    |                               |                                                                                                                |
| 微信发票             | ⛔    |                               |                                                                                                                |
| 微信非税缴费           | ⛔    |                               |                                                                                                                |
| 扫服务号二维码打开小程序     | ⛔    |                               |                                                                                                                |

## 1. 用法

<!-- 罗列各接口的使用API -->

### 1.1 基本用法

1. **创建Service对象**

所有Service接口的的默认实现都是以DefaultXXXX开头的。如`ServerService的实现类为DefaultServerService`

```
String appId = "", appSecret = "";
WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
DefaultWeChatMpAccessTokenService weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
ServerService mpServerService = new DefaultServerService(weChatMpAccessTokenService);
```

2. **通过Service A实例获取Service B的实例**

如通过`ServerService`获取`OpenApiService`实例

- **方式一: 直接通过`ofXXXX`获取对应Service**

```
OpenApiService openApiService  = serverService.ofOpenApiService();
```

- **方式二: 通过`<T extends WeChatService> T of(Class<T> toWeChatService)`获取对应Service**

`toWeChatService`为对应Service的实现类, 一般为`DefaultXXXService`

```
OpenApiService openApiService  = serverService.of(DefaultOpenApiService.class);
```

### 1.2 通用接口

见 `微信公众平台接入模块` 测试用例用法。

## 2. AccessToken 说明

AccessToken无需单独获取和指定，调用Api方法时，会自动获取并缓存AccessToken.
AccessToken由`WeChatMpAccessTokenService`维护，且缓存由`WeChatTokenStorage`维护。

### 2.1 access_token获取

- **方式一: 使用`WeChatMpAccessTokenService`获取token**

```
String appId = "", appSecret = "";
WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
WeChatMpAccessTokenService weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
String token = weChatMpAccessTokenService.getToken();
```

- **方式二: 使用Service实例获取token**

```
String token = serverService.getToken();
```

### 2.2 access_token刷新

- **方式一: 自动刷新**

调用Api方法时，若收到微信`40014:不合法的 access_token ，请开发者认真比对 access_token 的有效性（如是否过期），或查看是否正在为恰当的公众号调用接口`
时,会自动重新请求AccessToken。

- **方式二: 通过`WeChatMpAccessTokenService`刷新AccessToken**

刷新后会自动更新到缓存中。

```
weChatMpAccessTokenService.tokenRefresh()
# 或
weChatMpAccessTokenService.token(true)
```

### 2.3 access_token缓存

AccessToken缓存由`WeChatTokenStorage`维护，默认实现为`DefaultLocalWeChatTokenStorage`。
可在实例化`WeChatMpConfig`时指定`WeChatTokenStorage`。

1. **默认缓存`DefaultLocalWeChatTokenStorage`**

AccessToken缓存在当前Jvm中。

```
WeChatMpConfig weChatMpConfig = new WeChatMpConfig(appId, appSecret);
weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfig);
```

2. **指定`WeChatTokenStorage`实现类**

指定为Redis缓存实现类。

```
String redisAddress = "redis://127.0.0.1:6379";
Integer database = 0;

WeChatMpConfig weChatMpConfigWithRedis = new WeChatMpConfig(appId, appSecret);
weChatMpConfigWithRedis.setRedisConfig(WeChatRedisConfigFactory.newConfig(WeChatRedisConfig.ServerType.SingleServer, redisAddress, database));
RedisWeChatTokenStorage mpServerServiceWithRedisStorage = new RedisWeChatTokenStorage(weChatMpConfigWithRedis);
weChatMpConfigWithRedis.setWeChatTokenStorage(mpServerServiceWithRedisStorage);
weChatMpAccessTokenService = new DefaultWeChatMpAccessTokenService(weChatMpConfigWithRedis);
```

## 3. 接口扩展

可通过继承`AbstractWeChatMpService`类来快速接入微信公众号API, 并使用其中的`post`,`get`方法。
调用`post`,`get`方法时，可以指定是否需要AccessToken。

如:

```
public class DefaultServerService extends AbstractWeChatMpService implements ServerService {
    public DefaultServerService(WeChatMpConfig weChatConfig) {
        super(weChatConfig);
    }

    public DefaultServerService(WeChatMpAccessTokenService weChatMpAccessTokenService) {
        super(weChatMpAccessTokenService);
    }

    public DefaultServerService(WeChatMpAccessTokenService weChatMpAccessTokenService, RequestFilterChain requestFilterChain) {
        super(weChatMpAccessTokenService, requestFilterChain);
    }
}
```

## 4. 消息和事件

// TODO xxx

### 4.1 消息

### 4.2 事件

## 附录

### A. 微信公众号官方文档

#### 公众平台开发文档

[https://developers.weixin.qq.com/doc/offiaccount/Getting_Started](https://developers.weixin.qq.com/doc/offiaccount/Getting_Started/Overview.html)

#### 公众平台更新日志

[https://developers.weixin.qq.com/doc/offiaccount/Getting_Started/Update_log.html](https://developers.weixin.qq.com/doc/offiaccount/Getting_Started/Update_log.html)

#### 公众平台接入指南

[https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Access_Overview.html](https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Access_Overview.html)

#### 微信公众平台接口测试帐号系统

[https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login](https://mp.weixin.qq.com/debug/cgi-bin/sandbox?t=sandbox/login)

#### 微信公众平台接口调试工具

[https://mp.weixin.qq.com/debug/cgi-bin/apiinfo](https://mp.weixin.qq.com/debug/cgi-bin/apiinfo)