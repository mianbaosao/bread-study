package com.mianbao.forum.infa.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (ForumBlogdata)实体类
 *
 * @author makejava
 * @since 2024-10-17 18:52:13
 */
@Data
public class ForumBlogdata implements Serializable {
    private static final long serialVersionUID = -29666616524629275L;

    private Integer blogid;

    private String cover;

    private String title;

    private String writer;

    private String categoryname;

    private String allowcomment;

    private String statusname;

    private Integer status;

    private String content;

    private String description;

    private Integer categoryid;

    private String allowissue;

    private Date time;

    private Integer browse;

    private Integer likes;


}

