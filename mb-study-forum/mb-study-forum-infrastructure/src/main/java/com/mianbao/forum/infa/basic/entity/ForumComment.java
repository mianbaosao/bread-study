package com.mianbao.forum.infa.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (ForumComment)实体类
 *
 * @author makejava
 * @since 2024-10-17 18:52:21
 */
@Data
public class ForumComment implements Serializable {
    private static final long serialVersionUID = 319008356921198560L;

    private Integer id;

    private Integer blogid;

    private Integer userid;

    private String username;

    private Date time;

    private Integer parentid;

    private String content;

    private String cover;

    private String parentname;


}

