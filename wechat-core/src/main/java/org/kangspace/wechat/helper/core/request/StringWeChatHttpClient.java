package org.kangspace.wechat.helper.core.request;

import org.kangspace.wechat.helper.core.request.serialize.DataSerializerFactory;

/**
 * 字符串HttpClient
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/4
 */
public class StringWeChatHttpClient extends WechatNettyHttpClient {

    public StringWeChatHttpClient() {
        super(null, DataSerializerFactory.defaultStringSerializers());
    }
}
