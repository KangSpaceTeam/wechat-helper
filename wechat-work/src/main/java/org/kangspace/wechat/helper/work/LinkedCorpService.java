package org.kangspace.wechat.helper.work;

import org.kangspace.wechat.helper.work.bean.*;

/**
 * 企业微信"通讯录管理-互联企业"相关 Service
 *
 * @author kango2gler@gmail.com
 * @since 2023/07/27
 */
public interface LinkedCorpService extends WeComService {

    /**
     * 通讯录管理-互联企业-获取应用的可见范围
     * @return {@link LinkedCorpAgentGetPermListResponse}
     */
    LinkedCorpAgentGetPermListResponse linkedCorpAgentGetPermList();

    /**
     * 通讯录管理-互联企业-获取互联企业成员详细信息
     * @param request {@link LinkedCorpUserGetRequest}
     * @return {@link LinkedCorpUserGetResponse}
     */
    LinkedCorpUserGetResponse linkedCorpUserGet(LinkedCorpUserGetRequest request);

    /**
     * 通讯录管理-互联企业-获取互联企业部门成员
     * @param request {@link LinkedCorpUserSimpleListRequest}
     * @return {@link LinkedCorpUserSimpleListResponse}
     */
    LinkedCorpUserSimpleListResponse linkedCorpUserSimpleList(LinkedCorpUserSimpleListRequest request);

    /**
     * 通讯录管理-互联企业-获取互联企业部门成员详情
     * @param request {@link LinkedCorpUserListRequest}
     * @return {@link LinkedCorpUserListResponse}
     */
    LinkedCorpUserListResponse linkedCorpUserList(LinkedCorpUserListRequest request);

    /**
     * 通讯录管理-互联企业-获取互联企业部门列表
     * @param request {@link LinkedCorpDepartmentListRequest}
     * @return {@link LinkedCorpDepartmentListResponse}
     */
    LinkedCorpDepartmentListResponse linkedCorpDepartmentList(LinkedCorpDepartmentListRequest request);
}
