package com.mianbao.auth.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色dto
 *
 * @author: bread
 * @date: 2024/09/18
 */
@Data
public class AuthRoleDTO implements Serializable {

    private Long id;

    //角色名称
    private String roleName;

    //角色唯一标识
    private String roleKey;

}

