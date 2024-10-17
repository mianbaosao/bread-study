package com.mianbao.forum.common.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Description: bo
 * @Author:bread
 * @Date: 2024-10-17 19:17
 */
@Data
public class BlogDataBO {
    private Integer blogid;

    private String cover;

    private String title;

    private String writer;

    private String categoryname;

    private String allowcomment;

    private String statusname;

    //private Integer status;

    private String content;

    private String description;

    private Integer categoryid;

    //private String allowissue;

    private Date time;

    private Integer browse;

    private Integer likes;


}
