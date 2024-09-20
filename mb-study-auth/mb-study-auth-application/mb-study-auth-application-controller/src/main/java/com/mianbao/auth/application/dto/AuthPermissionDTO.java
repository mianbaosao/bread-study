package com.mianbao.auth.application.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限dto
 *
 * @author: bread
 * @date: 2024/09/18
 */
@Data
public class AuthPermissionDTO implements Serializable {

    // 权限ID
    private Long id;

    // 权限名称
    private String name;

    // 父权限ID
    private Long parentId;

    // 权限类型
    private Integer type;

    // 菜单URL
    private String menuUrl;

    // 状态
    private Integer status;

    // 是否显示
    private Integer show;

    // 图标
    private String icon;

    // 权限唯一标识
    private String permissionKey;
}

