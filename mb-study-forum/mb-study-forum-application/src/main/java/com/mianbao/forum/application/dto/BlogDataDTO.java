package com.mianbao.forum.application.dto;

import com.stduy.forum.common.entity.PageInfo;
import lombok.Data;

/**
 * @Description: 博客内容dto
 * @Author:bread
 * @Date: 2024-10-17 19:07
 */
@Data
public class BlogDataDTO extends PageInfo {

    /**
     * 博客id
     */
    private Integer blogid;

    /**
     * 分类id
     */
    private Integer categoryid;

}
