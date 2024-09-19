package com.mianbao.auth.domain.service;


import com.mianbao.auth.domain.entity.AuthRoleBO;

/**
 * 角色领域service
 *
 * @Author:bread
 * @Date: 2024-09-16 15:31
 */
public interface AuthRoleDomainService {

    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);

}
