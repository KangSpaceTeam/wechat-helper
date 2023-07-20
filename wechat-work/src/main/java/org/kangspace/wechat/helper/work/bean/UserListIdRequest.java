package org.kangspace.wechat.helper.work.bean;

import lombok.Builder;
import lombok.Data;

/**
 * 获取成员ID列表 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/20
 */
@Data
@Builder
public class UserListIdRequest {
    /**
     * 用于分页查询的游标，字符串类型，由上一次调用返回，首次调用不填
     */
    private String cursor;
    /**
     * 分页，预期请求的数据量，取值范围 1 ~ 10000
     */
    private Integer limit;

    public UserListIdRequest(String cursor, Integer limit) {
        this.cursor = cursor;
        this.limit = limit;
    }

    public UserListIdRequest() {
    }
}
