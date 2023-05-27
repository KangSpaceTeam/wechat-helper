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

### 1.2 通用接口

#### 1. 获取AccessToken

#### 2. 获取微信服务器IP地址

#### 3. 网络检测

## 2. AccessToken 说明

1. access_token获取

2. access_token刷新

3. access_token缓存

## 3. 接口扩展

## 4. 消息和事件

### 4.1 消息

1. 文本消息 
- 明文:
    
    > POST /wechat-platform/message?signature=f0b32354a7dbb3a81d6b581ce8630c890c639dc4&timestamp=1672369434&nonce=868403012&openid=oMIE-6T2iTOgEdERSg26CU0KL8Og
    
    body:
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

- 混合
    > POST /wechat-platform/message?signature=4d63b2865bff0f727b20ab5e7044824bce0c190c&timestamp=1672368683&nonce=1011679778&openid=oMIE-6T2iTOgEdERSg26CU0KL8Og&encrypt_type=aes&msg_signature=228c52a8d86c9dd454240e5fd0b626dcd2abd361
    
    body:
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

- 安全模式

    > signature=af0293fa28d9295bbeed7d14682f33b67b40ac11, timestamp=1673663596, nonce=1010515247, encryptType=aes,  msgSignature=7cfc35554d3d386235bf953e0d2ce6e9974eca53)
    
    body: 
    ```
    <xml>
    <ToUserName><![CDATA[gh_84671c4da479]]></ToUserName>
    <Encrypt><![CDATA[9Pux/NPOnudB7dIiCsAoHuytXARo0YJEnU11nKmhdnsAzV1hM9nRWQbOfgglSgz37eIrGeGDduvKyl7SZ0Dlb1N3chKE7inf/kpl1uirf7ySJgdFWY/TiJkyTRLPoi0Vpbheor1Wc4q91TFtypJ19OUckIL3GTsNHrfzK7dmS2q73paB/IwkPV0xl9NIL4LtM8/+IWuxowkzOrUc41TOoZnDZ/lfI335R6Ywiioptds64exEtIEQCVV0bjSpYUXibdOEfo8TBf0dwRXf2FwfiVhtLnS6EaRye9weNrrlEVrKyM3sAIZ7nUurQiM5/TpHrnQH9xXWa5W1QH9lPUUwWDO00L0Lpf2e/KxYvfE4EZjghNiz2ucZSKeXZG6rD2f5b8299TIcswaeau0lV6qESuJEZPKq06knExoSwx+e8Gw=]]></Encrypt>
    </xml>
    ```

2. 图片消息

    > signature=695a62925a7a6fcecbf96c2e593cffd2cf11fe57, timestamp=1673317844, nonce=61743237
    
    body: 
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
    
    > signature=d07daaa80f94ac3c69e3e2510fb7499769701147, timestamp=1673929361, nonce=226823177
    
    body: 
    ```
    <xml><ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
    <FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
    <CreateTime>1673929361</CreateTime>
    <MsgType><![CDATA[voice]]></MsgType>
    <MediaId><![CDATA[8AFksrG7bKh_RAaz64vffLNS9wCdsMAfrqC3km62GZUtEgHJd-rHJySf7VmPlztQ]]></MediaId>
    <Format><![CDATA[amr]]></Format>
    <MsgId>23964906520257817</MsgId>
    <Recognition><![CDATA[]]></Recognition>
    </xml>
    ```   

4. 视频消息

    > signature=78ab5abd724c4ecc49d617a4c30570afe7ad4f9f, timestamp=1673930863, nonce=1668497985
    
    body: 
    ``` 
    <xml><ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
    <FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
    <CreateTime>1673930861</CreateTime>
    <MsgType><![CDATA[video]]></MsgType>
    <MediaId><![CDATA[bhdru4vbXsWWVqx-HZifCISSLTCkg96bCI8YqupJeXbBmKQDyRcl_1xIC0k7v7Yipb9DZIlwUAJvUeWMz18ioQ]]></MediaId>
    <ThumbMediaId><![CDATA[bhdru4vbXsWWVqx-HZifCLbrIRhrckYCFgoDewz-5dYcgYACXc6js3yZ8aCxzJmk]]></ThumbMediaId>
    <MsgId>23964928508732800</MsgId>
    </xml>
    ```

5. 小视频消息

6. 位置消息

    > signature=dc8716e9b72b8f26d53cafd439dcbce1bf29651a, timestamp=1673229218, nonce=905465750
    
    body: 
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
    
    body: 
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

### 4.2 事件

1. CLICK事件

    > (signature=fd6a576defb6f521ecc6ee593ea6dbdb31aa04ec, timestamp=1673229375, nonce=493853253), encryptType=null, msgSignature=null)
    
    body: 
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
    
    body: 
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
    
    body: 
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
   
    body:
    ```
    <xml><ToUserName><![CDATA[gh_2f7bd96befaf]]></ToUserName>
    <FromUserName><![CDATA[oOIaHt5IOo6rI8BH8IOiG3lA0yHU]]></FromUserName>
    <CreateTime>1673501834</CreateTime>
    <MsgType><![CDATA[event]]></MsgType>
    <Event><![CDATA[unsubscribe]]></Event>
    <EventKey><![CDATA[]]></EventKey>
    </xml>
    ```

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