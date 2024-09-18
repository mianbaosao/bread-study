package com.mianbao.auth.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (AuthRolePermission)实体类
 *
 * @author: bread
 * @date: 2024/09/18
 */
@Data
public class AuthRolePermissionDTO implements Serializable {
    private static final long serialVersionUID = 459343371709166261L;
    
    private Long id;
    
    private Long roleId;
    
    private Long permissionId;

    private List<Long> permissionIdList;
}

