package org.kangspace.wechat.helper.core.request;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 微信公众号公共Http响应对象
 * @author kango2gler@gmail.com
 * @since 2022/10/1
 */
public abstract class AbstractWeChatResponse<T> implements WeChatResponse<T>{

    /**
     * 响应头
     * @return Map
     */
    @Override
    public Map<String, String> headers(){
        return Collections.emptyMap();
    }

    /**
     * cookie
     * @return Map
     */
    @Override
    public Map<String, Set<String>> cookies(){
        return Collections.emptyMap();
    }
}
