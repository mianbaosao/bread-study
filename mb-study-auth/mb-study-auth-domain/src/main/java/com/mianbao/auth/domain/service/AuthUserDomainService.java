package com.mianbao.auth.domain.service;




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
}

