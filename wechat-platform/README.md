# wechat-platform 微信开发平台

# 1. 微信公众号消息Token验证和消息接口

## 1.1 微信公众号Token验证

> GET wechat-platform/message

示例:

>
GET http://localhost:8080/wechat-platform/message?signature=8cba18b0eed872066919a8744b0f279b0fd8abfd&echostr=4011207248104127935&timestamp=1671953598&nonce=747722185

## 1.2 微信公众号消息接口

> POST wechat-platform/message