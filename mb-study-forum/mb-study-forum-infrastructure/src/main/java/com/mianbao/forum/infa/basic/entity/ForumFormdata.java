package com.mianbao.forum.infa.basic.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ForumFormdata)实体类
 *
 * @author makejava
 * @since 2024-10-17 18:52:22
 */
@Data
public class ForumFormdata implements Serializable {
    private static final long serialVersionUID = -47270163393864886L;

    private String cover;

    private String categoryname;

    private String categorydesc;

    private Integer blogcount;

    private Integer categoryid;


}

