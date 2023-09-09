package org.kangspace.wechat.helper.mp.message;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 语音消息<br>
 * 接口文档: <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html">https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Receiving_standard_messages.html</a>
 * <pre>
 * 请注意，开通语音识别后，用户每次发送语音给公众号时，微信会在推送的语音消息 XML 数据包中，增加一个 Recognition 字段（注：由于客户端缓存，开发者开启或者关闭语音识别功能，对新关注者立刻生效，对已关注用户需要24小时生效。开发者可以重新关注此帐号进行测试）。
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/01/01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VoiceMessage extends StandardMessage {

    /**
     * 图片消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    @JacksonXmlProperty(localName = "MediaId")
    @JacksonXmlCData
    private String mediaId;

    /**
     * 语音格式，如amr，speex等
     */
    @JacksonXmlProperty(localName = "Format")
    @JacksonXmlCData
    private String format;
    /**
     * 语音识别结果，UTF8编码
     */
    @JacksonXmlProperty(localName = "Recognition")
    @JacksonXmlCData
    private String recognition;
}
