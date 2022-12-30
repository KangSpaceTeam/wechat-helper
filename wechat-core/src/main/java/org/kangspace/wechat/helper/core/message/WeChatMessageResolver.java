package org.kangspace.wechat.helper.core.message;

import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.exception.WeChatSignatureException;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;
import org.kangspace.wechat.helper.core.util.XmlParser;

import java.util.List;

/**
 * 微信消息解析器<br>
 * 注意:
 * <pre>
 * 需重写 {@link #resolve(MessageSignature, String)} 或 {@link #solve(MessageSignature, String)} /
 *       {@link #resolve(MessageFormat, MessageSignature, String)} 或 {@link #solve(MessageFormat, MessageSignature, String)}
 * 方法。
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
public interface WeChatMessageResolver<Service extends WeChatService, Handler extends WeChatMessageHandler<Service, Message, EchoMessage>, Message extends WeChatMessage, EchoMessage extends WeChatEchoMessage> {

    /**
     * 获取所有消息的处理器
     *
     * @return {@link List}&lt;{@link Handler}&gt;
     */
    List<Handler> getWeChatHandlers();

    /**
     * 根据{@link Message}获取处理器列表
     *
     * @param Message {@link Message}
     * @return {@link List}&lt;{@link Handler}&gt;
     */
    List<Handler> getWeChatHandlers(Message Message);

    /**
     * 添加事件处理器
     *
     * @param messageHandler {@link Handler}
     */
    void addWeChatHandler(Handler messageHandler);

    /**
     * 获取WeChatService
     *
     * @return {@link Service}
     */
    Service getWeChatService();

    /**
     * 签名检查
     *
     * @param signature {@link BaseMessageSignature}
     * @return boolean
     */
    boolean checkSignature(BaseMessageSignature signature);

    /**
     * 签名检查(不通过时抛出异常)
     * @param signature {@link BaseMessageSignature}
     */
    default void checkSignatureThrows(BaseMessageSignature signature){
        if (!checkSignature(signature)) {
            throw new WeChatSignatureException("signature checked failed!");
        }
    }

    /**
     * 处理消息(无返回值)
     *
     * @param messageFormat    消息类型{@link MessageFormat}
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     */
    default void solve(MessageFormat messageFormat, MessageSignature messageSignature, String message) {
        throw new UnsupportedOperationException("need implements solve or resolve method!");
    }

    /**
     * 处理消息(无返回值, 默认XML消息)
     *
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     */
    default void solve(MessageSignature messageSignature, String message) {
        this.solve(MessageFormat.XML, messageSignature, message);
    }

    /**
     * 处理消息(带返回值)
     *
     * @param messageFormat    消息类型{@link MessageFormat}
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     */
    default EchoMessage resolve(MessageFormat messageFormat, MessageSignature messageSignature, String message) {
        this.solve(messageFormat, messageSignature, message);
        return null;
    }

    /**
     * 处理消息(默认XML消息)
     *
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     */
    default EchoMessage resolve(MessageSignature messageSignature, String message) {
        return this.resolve(MessageFormat.XML, messageSignature, message);
    }

    /**
     * 处理消息(返回字符串)
     *
     * @param messageFormat    消息类型{@link MessageFormat}
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     */
    default String resolveEcho(MessageFormat messageFormat, MessageSignature messageSignature, String message) {
        EchoMessage echoMessage = this.resolve(messageFormat, messageSignature, message);
        String echo = "";
        if (echoMessage != null) {
            echo = XmlParser.toXmlString(echoMessage);
        }
        return echo;
    }


    /**
     * 处理消息(返回字符串)
     *
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     */
    default String resolveEcho(MessageSignature messageSignature, String message) {
        return this.resolveEcho(MessageFormat.XML, messageSignature, message);
    }
}
