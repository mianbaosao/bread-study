package com.mianbao.auth.domain.service;



import com.mianbao.auth.domain.entity.AuthPermissionBO;

import java.util.List;

/**
 * 角色领域service
 *
 * @Author:bread
 * @Date: 2024-09-16 15:31
 */
public interface AuthPermissionDomainService {

    Boolean add(AuthPermissionBO authPermissionBO);

    Boolean update(AuthPermissionBO authPermissionBO);

    Boolean delete(AuthPermissionBO authPermissionBO);

    List<String> getPermission(String userName);
}
