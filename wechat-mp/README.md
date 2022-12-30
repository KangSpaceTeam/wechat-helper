# wechat-mp 微信公众平台模块

## 1. 用法

<!-- 罗列各接口的使用API -->

### 1.1 基本用法

### 1.2 通用接口

#### 1. 获取AccessToken

#### 2. 获取微信服务器IP地址

#### 3. 网络检测

## 2. AccessToken 说明

1. access_token获取

2. access_token刷新

3. access_token缓存

## 4. 接口扩展

## 5. 消息和事件

### 文本信息

明文:
> POST /wechat-platform/message?signature=f0b32354a7dbb3a81d6b581ce8630c890c639dc4&timestamp=1672369434&nonce=868403012&openid=oMIE-6T2iTOgEdERSg26CU0KL8Og

```xml
<xml><ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>
<FromUserName><![CDATA[oMIE-6T2iTOgEdERSg26CU0KL8Og]]></FromUserName>
<CreateTime>1672369434</CreateTime>
<MsgType><![CDATA[text]]></MsgType>
<Content><![CDATA[1]]></Content>
<MsgId>23942570635195977</MsgId>
</xml>
```

混合:
> POST /wechat-platform/message?signature=4d63b2865bff0f727b20ab5e7044824bce0c190c&timestamp=1672368683&nonce=1011679778&openid=oMIE-6T2iTOgEdERSg26CU0KL8Og&encrypt_type=aes&msg_signature=228c52a8d86c9dd454240e5fd0b626dcd2abd361

```xml
<xml>
    <ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>
    <FromUserName><![CDATA[oMIE-6T2iTOgEdERSg26CU0KL8Og]]></FromUserName>
    <CreateTime>1672368682</CreateTime>
    <MsgType><![CDATA[text]]></MsgType>
    <Content><![CDATA[1]]></Content>
    <MsgId>23942564675277696</MsgId>
    <Encrypt><![CDATA[lfg8C3BexN3OZky0BeFDydz2YwQZxvRkJCHTjnhGvLnaSl/Whb4mLWehqGME/klOCbMyisJQ6atP9ujmZCV5Suu/tdKg9P2WHNkWVxxFpvWMHA/bG7nIF+4TnlLPIaxdpisZHZ2cxbrceIkWQCJaOJ8LWTU4tyXsuuugdLA3juYrMNtJZgN6iIZExuLY4D3vooxVu4234ve5XK3foK0zAGTDBdUvJXBC2FX4eOcal/0fDBw9kjzmP+5brEimi6MMnoqMMPHBD1izvm97ovov5Mg0qqkKfVD1wf/JeQo38O8xTy3S+Dg+Cs8l7fyMu1/g6qucsQ3Iveo7rZa4qZpdMh9EA5V9/bLLJHoxj00Fq0dqrxHC9+SW+2f5oXukjqyxCcdVVEZgk7vJVJfh4SyVO9RE1cudgQVv0Ay0iCmuUcE=]]></Encrypt>
</xml>

```

### 事件

> POST /wechat-platform/message?signature=2fa6d6663dc078f7580bf82ba68465e63c5342de&timestamp=1672033304&nonce=966813369&openid=oOIaHt5IOo6rI8BH8IOiG3lA0yHU

```xml

<xml>
    <ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
    <FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
    <CreateTime>1672033304</CreateTime>
    <MsgType><![CDATA[event]]></MsgType>
    <Event><![CDATA[CLICK]]></Event>
    <EventKey><![CDATA[API_MENU_P_2]]></EventKey>
</xml>

```

## 6. TODO

1. 自定义菜单事件推送
2. 基础消息能力事件推送,接收消息,模版消息事件推送,群发接口和原创校验

## 附录

### 1. 微信公众号官方文档

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