package org.kangspace.wechat.helper.mp.event;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.event.AbstractWeChatEventResolver;
import org.kangspace.wechat.helper.core.message.MessageFormat;
import org.kangspace.wechat.helper.core.message.MessageSignature;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;

import java.util.List;

/**
 * 微信公众号事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
@Slf4j
public class WeChatMpEventResolver extends AbstractWeChatEventResolver<WeChatMpService, WeChatMpEventHandler<WeChatMpEvent>, WeChatMpEvent, WeChatMpEchoMessage> {

    public WeChatMpEventResolver(WeChatMpService wechatService) {
        super(wechatService);
    }

    public WeChatMpEventResolver(WeChatMpService wechatService, List<WeChatMpEventHandler<WeChatMpEvent>> weChatEventHandlers) {
        super(wechatService, weChatEventHandlers);
    }

    @Override
    public WeChatMpEchoMessage resolve(MessageFormat messageFormat, MessageSignature messageSignature, String message) {
        throw new UnsupportedOperationException("method not support!");
    }
}
