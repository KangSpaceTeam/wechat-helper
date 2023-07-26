package org.kangspace.wechat.helper.work.event;

/**
 * 企业微信事件-含ChangeType的事件
 *
 * @author kango2gler@gmail.com
 * @since 2023/07/25
 */
public interface WeComChangeTypeEvent {

    /**
     * 获取变更类型
     *
     * @return changeTYpe
     */
    String getChangeType();
}
