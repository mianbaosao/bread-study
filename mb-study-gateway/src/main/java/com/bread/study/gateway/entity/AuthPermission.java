package com.bread.study.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AuthPermission)实体类
 *
 * @author makejava
 * @since 2023-11-03 00:45:50
 */
@Data
public class AuthPermission implements Serializable {
    private static final long serialVersionUID = -56518358607843924L;
    
    private Long id;
    
    private String name;
    
    private Long parentId;
    
    private Integer type;
    
    private String menuUrl;
    
    private Integer status;
    
    private Integer show;
    
    private String icon;
    
    private String permissionKey;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    
    private Integer isDeleted;



}

