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
> POST /wechat-platform/message?signature=812895b1f140e1397f4576452383be3b3271b1f2&timestamp=1672033292&nonce=1313676274&openid=oOIaHt5IOo6rI8BH8IOiG3lA0yHU

```xml

<xml>
    <ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
    <FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
    <CreateTime>1672033292</CreateTime>
    <MsgType><![CDATA[text]]></MsgType>
    <Content><![CDATA[1]]></Content>
    <MsgId>23937761304782045</MsgId>
</xml>
```

混合:
> POST /wechat-platform/message?signature=4531152dfaa32d83bda1451595b434eedbaee8c6&timestamp=1672062037&nonce=924856700&openid=oMIE-6T2iTOgEdERSg26CU0KL8Og&encrypt_type=aes&msg_signature=3fae3477f04d2805bb2f647d67f98ead14fc5f6e

```xml

<xml>
    <ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>
    <FromUserName><![CDATA[oMIE-6T2iTOgEdERSg26CU0KL8Og]]></FromUserName>
    <CreateTime>1672062036</CreateTime>
    <MsgType><![CDATA[text]]></MsgType>
    <Content><![CDATA[1]]></Content>
    <MsgId>23938173794149768</MsgId>
    <Encrypt>
        <![CDATA[tybon2345ToFXFumMtSoJ0i6F5PGT6BIJudVM+TIkPjfR9o9hrsyVa7yGcWIBpeaK57/mDXfYSNSgjmzfk5AecAMvDb7blMwc1wNEGwvOsh7LkfX+8jT/8SyQ3o5BvUi/0maQBtuQQ9L5REk829Oj0zpXsxwaCEX2kQrJ3AMA7/wwom+u9UXstEQzIbMyC20zxlx9/kzGQEqmME3xhBhBvBH5TCQO7foUMTb+7xZNNbzraBMWwsz+orXNvNMliqiAPcJIRJBeh7OCwi5wssrO2ujtiTrG5uln0/0uNBaIWTKSR7yI1Ddnfd4c7gR1Q2N/Uyz0+TRGDeJsnd/jB5Qn6Ur10eAEyxL+uwHbjXemMntHRHad3CtsD2+3wV3VQL4jBC6bCYJp9TrEiCsYn/eqrSceDLWu54li8iN+RS7B4U=]]></Encrypt>
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