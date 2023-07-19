package org.kangspace.wechat.helper.work.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 企业微信通讯录管理-成员管理-成员 请求对象
 * <pre>
 * </pre>
 *
 * @author kango2gler@gmail.com
 * @since 2023/7/17
 */
@Data
@Builder
public class UserRequest {

    /**
     * 成员UserID。对应管理端的帐号，企业内必须唯一。长度为1~64个字节。只能由数字、字母和“_-@.”四种字符组成，且第一个字符必须是数字或字母。系统进行唯一性检查时会忽略大小写。
     */
    @JsonProperty("userid")
    private String userId;
    /**
     * 如果userid由系统自动生成，则仅允许修改一次。新值可由new_userid字段指定。
     */
    @JsonProperty("new_userid")
    private String newUserId;

    /**
     * 成员名称。长度为1~64个utf8字符
     */
    private String name;

    /**
     * 成员别名。长度1~64个utf8字符
     */
    private String alias;

    /**
     * 手机号码。企业内必须唯一，mobile/email二者不能同时为空
     */
    private String mobile;

    /**
     * 成员所属部门id列表，不超过100个
     */
    private List<Long> department;

    /**
     * 部门内的排序值，默认为0，成员次序以创建时间从小到大排列。个数必须和参数department的个数一致，数值越大排序越前面。有效的值范围是[0, 2^32)
     */
    private List<Integer> order;

    /**
     * 职务信息。长度为0~128个字符
     */
    private String position;

    /**
     * 性别。1表示男性，2表示女性
     */
    private Integer gender;

    /**
     * 邮箱。长度6~64个字节，且为有效的email格式。企业内必须唯一，mobile/email二者不能同时为空
     */
    private String email;

    /**
     * 企业邮箱。仅对开通企业邮箱的企业有效。长度6~64个字节，且为有效的企业邮箱格式。企业内必须唯一。未填写则系统会为用户生成默认企业邮箱（由系统生成的邮箱可修改一次，2022年4月25日之后创建的成员需通过企业管理后台-协作-邮件-邮箱管理-成员邮箱修改）
     */
    @JsonProperty("biz_mail")
    private String bizMail;

    /**
     * 个数必须和参数department的个数一致，表示在所在的部门内是否为部门负责人。1表示为部门负责人，0表示非部门负责人。在审批(自建、第三方)等应用里可以用来标识上级审批人
     */
    @JsonProperty("is_leader_in_dept")
    private List<Integer> isLeaderInDept;

    /**
     * 直属上级UserID，设置范围为企业内成员，可以设置最多5个上级
     */
    @JsonProperty("direct_leader")
    private List<String> directLeader;

    /**
     * 成员头像的mediaid，通过素材管理接口上传图片获得的mediaid
     */
    @JsonProperty("avatar_mediaid")
    private String avatarMediaId;

    /**
     * 启用/禁用成员。1表示启用成员，0表示禁用成员
     */
    private String enable;

    /**
     * 座机。32字节以内，由纯数字、“-”、“+”或“,”组成。
     */
    private String telephone;


    /**
     * 地址。长度最大128个字符
     */
    private String address;

    /**
     * 视频号名字（设置后，成员将对外展示该视频号）。须从企业绑定到企业微信的视频号中选择，可在“我的企业”页中查看绑定的视频号
     */
    private String nickname;


    /**
     * 主部门
     */
    @JsonProperty("main_department")
    private Long mainDepartment;

    /**
     * 自定义字段。自定义字段需要先在WEB管理端添加，见扩展属性添加方法，否则忽略未知属性的赋值。
     */
    @JsonProperty("extattr")
    private ExternalAttr extAttr;

    /**
     * 对外职务，如果设置了该值，则以此作为对外展示的职务，否则以position来展示。长度12个汉字内
     */
    @JsonProperty("external_position")
    private String externalPosition;

    /**
     * 成员对外属性，字段详情见对外属性
     */
    @JsonProperty("external_profile")
    private ExternalProfile externalProfile;

    /**
     * 是否邀请该成员使用企业微信（将通过微信服务通知或短信或邮件下发邀请，每天自动下发一次，最多持续3个工作日），默认值为true。
     */
    @JsonProperty("to_invite")
    private Boolean toInvite;
}
