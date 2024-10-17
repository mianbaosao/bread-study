package com.mianbao.forum.infa.basic.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (ForumBolglikes)实体类
 *
 * @author makejava
 * @since 2024-10-17 18:52:21
 */
@Data
public class ForumBolglikes implements Serializable {
    private static final long serialVersionUID = 731514421437856222L;

    private Integer likeId;

    private Integer userId;

    private Integer blogId;

}

