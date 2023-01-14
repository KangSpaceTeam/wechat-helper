package org.kangspace.wechat.helper.mp.event;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.event.AbstractWeChatEventResolver;
import org.kangspace.wechat.helper.mp.WeChatMpService;
import org.kangspace.wechat.helper.mp.message.response.WeChatMpEchoMessage;

/**
 * 微信公众号事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
@Slf4j
public abstract class WeChatMpEventResolver extends AbstractWeChatEventResolver<WeChatMpService, WeChatMpEvent, WeChatMpEchoMessage> {
    public WeChatMpEventResolver(WeChatMpService wechatService) {
        super(wechatService);
    }
}
