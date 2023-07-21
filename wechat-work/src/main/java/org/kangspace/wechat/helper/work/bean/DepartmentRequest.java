package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 企业微信"通讯录管理-部门管理-部门" 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/21
 */
@Data
@Builder
public class DepartmentRequest {

    /**
     * 创建的部门id
     */
    private Long id;

    /**
     * 部门名称，代开发自建应用需要管理员授权才返回；此字段从2019年12月30日起，对新创建第三方应用不再返回，2020年6月30日起，对所有历史第三方应用不再返回name，返回的name字段使用id代替，后续第三方仅通讯录应用可获取，未返回名称的情况需要通过通讯录展示组件来展示部门名称
     */
    private String name;

    /**
     * 英文名称，需要在管理后台开启多语言支持才能生效。长度限制为1~64个字符，字符不能包括:*?"<>｜
     */
    @JsonProperty("name_en")
    private String nameEn;

    /**
     * 部门负责人的UserID；第三方仅通讯录应用可获取
     */
    @JsonProperty("department_leader")
    private String departmentLeader;

    /**
     * 父部门id。根部门为1
     */
    @JsonProperty("parentid")
    private Long parentId;

    /**
     * 在父部门中的次序值。order值大的排序靠前。值范围是[0, 2^32)
     */
    private Integer order;
}
