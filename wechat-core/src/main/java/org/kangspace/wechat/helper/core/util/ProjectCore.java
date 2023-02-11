package org.kangspace.wechat.helper.core.util;

import java.util.Optional;

/**
 * 项目核心信息
 *
 * @author kango2gler@gmail.com
 * @since 2023/02/05 13:26
 */
public class ProjectCore {
    /**
     * 项目名称
     */
    public final static String PROJECT_NAME = "wechat-helper";

    /**
     * User-Agent
     */
    public final static String USER_AGENT = String.format(PROJECT_NAME + "/%s", coreVersion());

    /**
     * 核心包(wechat-helper/wechat-core)版本号
     *
     * @return 版本号
     */
    public static String coreVersion() {
        return Optional.ofNullable(ProjectCore.class.getPackage().getImplementationVersion()).orElse("dev");
    }

    public static void main(String[] args) {
        System.out.println(USER_AGENT);
    }
}
