# 微信开发助手(wechat-helper)

[![License](http://img.shields.io/:license-mit-brightgreen.svg)](https://github.com/KangSpaceTeam/wechat-helper/blob/main/LICENSE)
![maven](https://img.shields.io/maven-central/v/org.kangspace.wechat.helper/wechat-helper)

[快速开始](#quick-start) | [文档](https://github.com/KangSpaceTeam/wechat-helper/wiki) | [Changelog](CHANGELOG.md)
| [Report an issue](https://github.com/KangSpaceTeam/wechat-helper/issues/new)

> 最新版本: 0.0.1

## 1. 模块

| 模块                                 | 说明           | 备注                     | 状态           |
|------------------------------------|--------------|------------------------|--------------|
| [wechat-core](wechat-core)         | 核心包          | http,exception,接口统一定义包 | ️📍          |
| [wechat-mp](wechat-mp)             | 微信公众号相关包     | 微信公众号接口,响应,错误码统一定义包    | 📍2023.05.28 |
| [wechat-miniapp](wechat-miniapp)   | 微信小程序相关包     | 微信小程序接口,响应,错误码统一定义包    | ⏳            |
| [wechat-open](wechat-open)         | 微信开放平台相关包    | 微信开放平台接口,响应,错误码统一定义包   | ⏳            |
| [wechat-work](wechat-work)         | 企业微信相关包      | 企业微信接口,响应,错误码统一定义包     | ⏳            |
| [wechat-pay](wechat-pay)           | 微信支付相关包      | 微信支付接口,响应,错误码统一定义包     | ⏳            |
| [wechat-monitor](wechat-monitor)   | 微信请求监控相关包    | 监听处理微信接口请求定义包          | ⏳            |
| [wechat-platform](wechat-platform) | 微信开发相关管理端相关包 | 微信开发相关管理端,web定义包       | ⏳            |
| [wechat-bom](wechat-bom)           | 依赖管理包        | 包版本管理                  | 📍2022.12.01 |

## [2. 快速开始](#quick-start)

### 2.1 微信公众号

见 [微信公众号(wechat-mp)](wechat-mp/README.md)

### 2.2 企业微信

见 [企微微信(wechat-work)](wechat-work/README.md)

### 3. Maven

> jdk: 1.8+

```
<dependency>
    <groupId>org.kangspace.wechat.helper</groupId>
    <artifactId>wechat-bom</artifactId>
    <version>${lastest-version}</version>
</dependency>
```


