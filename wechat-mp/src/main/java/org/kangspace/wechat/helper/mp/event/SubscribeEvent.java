package org.kangspace.wechat.helper.mp.event;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 关注/取消关注事件(关注)、扫描带参数二维码事件 <br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_event_pushes.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_event_pushes.html</a> <br>
 * <pre>
 * 关注/取消关注事件
 * 用户在关注与取消关注公众号时，微信会把这个事件推送到开发者填写的URL。方便开发者给用户下发欢迎消息或者做帐号的解绑。为保护用户数据隐私，开发者收到用户取消关注事件时需要删除该用户的所有信息。
 * 微信服务器在五秒内收不到响应会断掉连接，并且重新发起请求，总共重试三次。
 * 关于重试的消息排重，推荐使用FromUserName + CreateTime 排重。
 * 假如服务器无法保证在五秒内处理并回复，可以直接回复空串，微信服务器不会对此作任何处理，并且不会发起重试。
 *
 * </pre>
 * <pre>
 * 扫描带参数二维码事件
 * 用户扫描带场景值二维码时，可能推送以下两种事件：
 * 1. 如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
 * 2. 如果用户已经关注公众号，则微信会将带场景值扫描事件推送给开发者。
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SubscribeEvent extends WeChatMpXmlEvent {
    /**
     * 用户未关注时，进行关注后的事件推送,参数前缀
     */
    public static final String SUBSCRIPT_EVENT_KEY_PREFIX = "qrscene_";

    /**
     * 事件 KEY 值，qrscene_为前缀，后面为二维码的参数值<br>
     * 如果用户还未关注公众号，则用户可以关注公众号，关注后微信会将带场景值关注事件推送给开发者。
     */
    @JacksonXmlProperty(localName = "EventKey")
    @JacksonXmlCData
    private String eventKey;

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    @JacksonXmlProperty(localName = "Ticket")
    @JacksonXmlCData
    private String ticket;
}
