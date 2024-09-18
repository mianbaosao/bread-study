package com.mianbao.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色bo
 *
 * @author: bread
 * @date: 2024/09/18
 */
@Data
public class AuthRoleBO implements Serializable {

    private Long id;
    
    private String roleName;
    
    private String roleKey;

}

