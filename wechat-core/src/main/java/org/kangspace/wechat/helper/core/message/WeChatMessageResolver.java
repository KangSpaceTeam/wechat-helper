package org.kangspace.wechat.helper.core.message;

import org.kangspace.devhelper.xml.XmlParser;
import org.kangspace.wechat.helper.core.WeChatService;
import org.kangspace.wechat.helper.core.exception.WeChatSignatureException;
import org.kangspace.wechat.helper.core.message.response.WeChatEchoMessage;
import org.kangspace.wechat.helper.core.message.response.WeChatEncryptEchoMessage;

import java.util.Collection;
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
public interface WeChatMessageResolver<Service extends WeChatService,
        Message extends WeChatMessage,
        EchoMessage extends WeChatEchoMessage> {

    /**
     * 获取所有消息的处理器
     *
     * @return {@link List}&lt;{@link WeChatMessageHandler}&gt;
     */
    List<? extends WeChatMessageHandler<Service, ?, EchoMessage>> getWeChatHandlers();

    /**
     * 根据{@link Message}获取处理器列表
     *
     * @param Message {@link Message}
     * @return {@link List}&lt;{@link WeChatMessageHandler}&gt;
     */
    List<? extends WeChatMessageHandler<Service, ?, EchoMessage>> getWeChatHandlers(Message Message);

    /**
     * 添加事件处理器
     *
     * @param messageHandler {@link WeChatMessageHandler}
     * @return {@link WeChatMessageResolver}
     */
    <Handle extends WeChatMessageHandler<Service, ?, EchoMessage>,
            Resolver extends WeChatMessageResolver<Service, Message, EchoMessage>> Resolver addWeChatHandler(Handle messageHandler);

    /**
     * 批量添加事件处理器
     *
     * @param messageHandlers {@link WeChatMessageHandler}列表
     * @return {@link WeChatMessageResolver}
     */
    <Handle extends WeChatMessageHandler<Service, ?, EchoMessage>,
            Resolver extends WeChatMessageResolver<Service, Message, EchoMessage>> Resolver addWeChatHandlers(Collection<? extends Handle> messageHandlers);

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
    <T extends BaseMessageSignature> boolean checkSignature(T signature);

    /**
     * 签名检查(不通过时抛出异常)
     *
     * @param signature {@link BaseMessageSignature}
     */
    default void checkSignatureThrows(BaseMessageSignature signature) {
        if (!checkSignature(signature)) {
            throw new WeChatSignatureException(signature.getSignature(), "signature checked failed!");
        }
    }

    /**
     * 加密响应消息
     *
     * @param echoMessage 原响应消息
     * @return {@link T}
     */
    default <T extends WeChatEncryptEchoMessage> T encryptEcho(EchoMessage echoMessage) {
        throw new UnsupportedOperationException("need implements encryptEcho method!");
    }

    /**
     * 处理消息(无返回值)
     *
     * @param messageFormat    消息类型{@link MessageFormat}
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     * @param context          处理器上下文
     */
    default void solve(MessageFormat messageFormat, MessageSignature messageSignature, String message, MessageResolverContext context) {
        throw new UnsupportedOperationException("need implements solve or resolve method!");
    }

    /**
     * 处理消息(无返回值)
     *
     * @param messageFormat    消息类型{@link MessageFormat}
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     */
    default void solve(MessageFormat messageFormat, MessageSignature messageSignature, String message) {
        this.solve(messageFormat, messageSignature, message, MessageResolverContext.newContext());
    }

    /**
     * 处理消息(无返回值, 默认XML消息)
     *
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     * @param context          {@link MessageResolverContext}
     */
    default void solve(MessageSignature messageSignature, String message, MessageResolverContext context) {
        this.solve(MessageFormat.XML, messageSignature, message, context);
    }

    /**
     * 处理消息(无返回值, 默认XML消息)
     *
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     */
    default void solve(MessageSignature messageSignature, String message) {
        this.solve(messageSignature, message, MessageResolverContext.newContext());
    }

    /**
     * 处理消息(带返回值)
     *
     * @param messageFormat    消息类型{@link MessageFormat}
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     * @param context          {@link MessageResolverContext} 处理器上下文
     * @return {@link EchoMessage}
     */
    default EchoMessage resolve(MessageFormat messageFormat, MessageSignature messageSignature, String message, MessageResolverContext context) {
        this.solve(messageFormat, messageSignature, message, context);
        return null;
    }

    /**
     * 处理消息(带返回值)
     *
     * @param messageFormat    消息类型{@link MessageFormat}
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     * @return {@link EchoMessage}
     */
    default EchoMessage resolve(MessageFormat messageFormat, MessageSignature messageSignature, String message) {
        this.resolve(messageFormat, messageSignature, message, MessageResolverContext.newContext());
        return null;
    }

    /**
     * 处理消息(默认XML消息)
     *
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     * @param context          {@link MessageResolverContext} 处理器上下文
     * @return {@link EchoMessage}
     */
    default EchoMessage resolve(MessageSignature messageSignature, String message, MessageResolverContext context) {
        return this.resolve(MessageFormat.XML, messageSignature, message, context);
    }

    /**
     * 处理消息(默认XML消息)
     *
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     * @return {@link EchoMessage}
     */
    default EchoMessage resolve(MessageSignature messageSignature, String message) {
        return this.resolve(messageSignature, message, MessageResolverContext.newContext());
    }

    /**
     * 处理消息(返回字符串)
     *
     * @param messageFormat    消息类型{@link MessageFormat}
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     * @param context          {@link MessageResolverContext} 处理器上下文
     * @return 处理消息
     */
    @SuppressWarnings("unchecked")
    default String resolveEcho(MessageFormat messageFormat, MessageSignature messageSignature, String message, MessageResolverContext context) {
        EchoMessage echoMessage = this.resolve(messageFormat, messageSignature, message, context);
        String echo = "";
        if (echoMessage != null) {
            if (messageSignature.isEncrypt()) {
                echoMessage = encryptEcho(echoMessage);
            }
            echo = XmlParser.toXmlString(echoMessage);
        }
        return echo;
    }

    /**
     * 处理消息(返回字符串)
     *
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     * @param context          {@link MessageResolverContext} 处理器上下文
     * @return 返回消息
     */
    default String resolveEcho(MessageSignature messageSignature, String message, MessageResolverContext context) {
        return this.resolveEcho(MessageFormat.XML, messageSignature, message, context);
    }

    /**
     * 处理消息(返回字符串)
     *
     * @param messageSignature {@link MessageSignature}
     * @param message          消息
     * @return 返回消息
     */
    default String resolveEcho(MessageSignature messageSignature, String message) {
        return this.resolveEcho(messageSignature, message, MessageResolverContext.newContext());
    }
}
