package org.kangspace.wechat.helper.work.event;

import lombok.extern.slf4j.Slf4j;
import org.kangspace.wechat.helper.core.event.AbstractWeChatEventResolver;
import org.kangspace.wechat.helper.work.WeComService;
import org.kangspace.wechat.helper.work.message.response.WeComEchoMessage;

/**
 * 企业微信事件处理器
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/25
 */
@Slf4j
public abstract class WeComEventResolver extends AbstractWeChatEventResolver<WeComService, WeComEvent, WeComEchoMessage> {
    public WeComEventResolver(WeComService wechatService) {
        super(wechatService);
    }
}
