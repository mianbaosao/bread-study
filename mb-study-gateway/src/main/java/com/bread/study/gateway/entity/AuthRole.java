package com.bread.study.gateway.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (AuthRole)实体类
 *
 * @author: Bread
 * @date: 2024/09/17
 */
@Data
public class AuthRole implements Serializable {
    private static final long serialVersionUID = 422256240999600735L;
    
    private Long id;
    
    private String roleName;
    
    private String roleKey;
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

