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

### 消息

1. 文本消息 明文:

> POST /wechat-platform/message?signature=f0b32354a7dbb3a81d6b581ce8630c890c639dc4&timestamp=1672369434&nonce=868403012&openid=oMIE-6T2iTOgEdERSg26CU0KL8Og

```

<xml>
<ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>
<FromUserName><![CDATA[oMIE-6T2iTOgEdERSg26CU0KL8Og]]></FromUserName>
<CreateTime>1672369434</CreateTime>
<MsgType><![CDATA[text]]></MsgType>
<Content><![CDATA[1]]></Content>
<MsgId>23942570635195977</MsgId>
</xml>
```

> POST wechat-platform/message?signature=df7245e129709dfc38a003f029cf2749ff3c0da2&timestamp=1672982088&nonce=1045065514&openid=oOIaHt5IOo6rI8BH8IOiG3lA0yHU

```
<xml><ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
<FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
<CreateTime>1672982087</CreateTime>
<MsgType><![CDATA[text]]></MsgType>
<Content><![CDATA[1]]></Content>
<MsgId>23951344571027678</MsgId>
</xml>
```

混合:
> POST /wechat-platform/message?signature=4d63b2865bff0f727b20ab5e7044824bce0c190c&timestamp=1672368683&nonce=1011679778&openid=oMIE-6T2iTOgEdERSg26CU0KL8Og&encrypt_type=aes&msg_signature=228c52a8d86c9dd454240e5fd0b626dcd2abd361

```
<xml>
<ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>
<FromUserName><![CDATA[oMIE-6T2iTOgEdERSg26CU0KL8Og]]></FromUserName>
<CreateTime>1672368682</CreateTime>
<MsgType><![CDATA[text]]></MsgType>
<Content><![CDATA[1]]></Content>
<MsgId>23942564675277696</MsgId>
<Encrypt>
    <![CDATA[lfg8C3BexN3OZky0BeFDydz2YwQZxvRkJCHTjnhGvLnaSl/Whb4mLWehqGME/klOCbMyisJQ6atP9ujmZCV5Suu/tdKg9P2WHNkWVxxFpvWMHA/bG7nIF+4TnlLPIaxdpisZHZ2cxbrceIkWQCJaOJ8LWTU4tyXsuuugdLA3juYrMNtJZgN6iIZExuLY4D3vooxVu4234ve5XK3foK0zAGTDBdUvJXBC2FX4eOcal/0fDBw9kjzmP+5brEimi6MMnoqMMPHBD1izvm97ovov5Mg0qqkKfVD1wf/JeQo38O8xTy3S+Dg+Cs8l7fyMu1/g6qucsQ3Iveo7rZa4qZpdMh9EA5V9/bLLJHoxj00Fq0dqrxHC9+SW+2f5oXukjqyxCcdVVEZgk7vJVJfh4SyVO9RE1cudgQVv0Ay0iCmuUcE=]]></Encrypt>
</xml>
```

2. 图片消息

> signature=695a62925a7a6fcecbf96c2e593cffd2cf11fe57, timestamp=1673317844, nonce=61743237

```
<xml>
<ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
<FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
<CreateTime>1673317843</CreateTime>
<MsgType><![CDATA[image]]></MsgType>
<PicUrl>
    <![CDATA[http://mmbiz.qpic.cn/mmbiz_jpg/ayVWjvWWAxrU8TZticcnGokgvCopm4MtVgeuHiac8qh15dG8xEpqBK1MuSYcebicMUnkdrMo6libOYZF4JuXyP0vYw/0]]></PicUrl>
<MsgId>23956154084562088</MsgId>
<MediaId><![CDATA[L2Julf9yd3MeCc-JB0EuDIcMs6DHGt04KQcwY35565ME-wL0xS61jLMw9blNu7gX]]></MediaId>
</xml>
```

3. 语音消息

4. 视频消息

> signature=018024858e54cc26566030cd4567a90db161028f, timestamp=1673330366, nonce=1076523229), encryptType=null, msgSignature=null

```
<xml><ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
<FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
<CreateTime>1673330364</CreateTime>
<MsgType><![CDATA[video]]></MsgType>
<MediaId><![CDATA[G_-]]></MediaId>
<ThumbMediaId><![CDATA[G_-]]></ThumbMediaId>
<MsgId>23956328414742057</MsgId>
</xml>
```

5. 小视频消息

6. 位置消息

> signature=dc8716e9b72b8f26d53cafd439dcbce1bf29651a, timestamp=1673229218, nonce=905465750

```
<xml><ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
<FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
<CreateTime>1673229217</CreateTime>
<MsgType><![CDATA[location]]></MsgType>
<Location_X>39.956860</Location_X>
<Location_Y>116.329788</Location_Y>
<Scale>13</Scale>
<Label><![CDATA[海淀区学院南路78号]]></Label>
<MsgId>23954882564720902</MsgId>
</xml>
```

7. 链接消息

> signature=84cf1fb48628acf727353a94bfcf8df5762545ea, timestamp=1673330846, nonce=915317285

``` 
<xml><ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
<FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
<CreateTime>1673330845</CreateTime>
<MsgType><![CDATA[link]]></MsgType>
<Title><![CDATA[我是测试链接？]]></Title>
<Description><![CDATA[]]></Description>
<Url><![CDATA[http://mp.weixin.qq.com/s?__biz=]]></Url>
<MsgId>23956336553986824</MsgId>
</xml>
```

### 事件

> POST /wechat-platform/message?signature=2fa6d6663dc078f7580bf82ba68465e63c5342de&timestamp=1672033304&nonce=966813369&openid=oOIaHt5IOo6rI8BH8IOiG3lA0yHU

```
<xml>
<ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
<FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
<CreateTime>1672033304</CreateTime>
<MsgType><![CDATA[event]]></MsgType>
<Event><![CDATA[CLICK]]></Event>
<EventKey><![CDATA[API_MENU_P_2]]></EventKey>
</xml>
```

1. CLICK事件

> (signature=fd6a576defb6f521ecc6ee593ea6dbdb31aa04ec, timestamp=1673229375, nonce=493853253), encryptType=null, msgSignature=null)

```
<xml>
<ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
<FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
<CreateTime>1673229375</CreateTime>
<MsgType><![CDATA[event]]></MsgType>
<Event><![CDATA[CLICK]]></Event>
<EventKey><![CDATA[API_MENU_P_2]]></EventKey>
</xml>
```

2. 点击菜单跳转链接时的事件推送

> signature=625f3cfc297abbcfb6585d86352312b0fcb4837a, timestamp=1673500355, nonce=589328110

```
<xml><ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
<FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
<CreateTime>1673500354</CreateTime>
<MsgType><![CDATA[event]]></MsgType>
<Event><![CDATA[VIEW]]></Event>
<EventKey><![CDATA[https://kangspace.org]]></EventKey>
<MenuId>434408580</MenuId>
</xml>
```

3. 关注事件

> signature=a992a0b6be821f557e405d1da614df127d8af938, timestamp=1673501864, nonce=812038915

```
<xml><ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
<FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
<CreateTime>1673501864</CreateTime>
<MsgType><![CDATA[event]]></MsgType>
<Event><![CDATA[subscribe]]></Event>
<EventKey><![CDATA[]]></EventKey>
</xml>
```

4. 取消关注事件

> signature=17d7519b189b457f93033bd0bdd1d1bc790f6947, timestamp=1673501834, nonce=1093822964

```
<xml><ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
<FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
<CreateTime>1673501834</CreateTime>
<MsgType><![CDATA[event]]></MsgType>
<Event><![CDATA[unsubscribe]]></Event>
<EventKey><![CDATA[]]></EventKey>
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