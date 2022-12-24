package org.kangspace.wechat.helper.mp.bean;

import lombok.Data;

/**
 * 测试个性化菜单匹配结果 响应参数
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/10
 */
@Data
public class MenuTryMatchResponse extends WeChatMpResponseEntity {

    /**
     * 菜单
     */
    private MenuGetResponse.Menu menu;
}
