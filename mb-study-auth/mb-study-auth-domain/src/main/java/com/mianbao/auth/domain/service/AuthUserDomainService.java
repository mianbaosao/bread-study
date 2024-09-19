package com.mianbao.auth.domain.service;




import cn.dev33.satoken.stp.SaTokenInfo;
import com.mianbao.auth.domain.entity.AuthUserBO;

import java.util.List;

/**
 * 用户领域service
 *
 * @author: bread
 * @date: 2024/09/18
 */
public interface AuthUserDomainService {


    /**
     * 注册
     */
    Boolean register(AuthUserBO authUserBO);

    /**
     * 更新用户信息
     */
    Boolean update(AuthUserBO authUserBO);

    SaTokenInfo doLogin(String validCode);

    AuthUserBO getUserInfo(AuthUserBO authUserBO);

    List<AuthUserBO> listUserInfoByIds(List<String> ids);
}

