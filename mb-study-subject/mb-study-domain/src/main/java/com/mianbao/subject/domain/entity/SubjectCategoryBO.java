package com.mianbao.subject.domain.entity;

import lombok.Data;

import java.util.List;

/**
 * @Description: 分类实体类
 * @Author:bread
 * @Date: 2024-07-30 9:33
 */

@Data
public class SubjectCategoryBO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 分类类型
     */
    private Integer categoryType;

    /**
     * 图标连接
     */
    private String imageUrl;

    /**
     * 父级id
     */
    private Long parentId;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 标签bo数量
     */
    private List<SubjectLabelBO> labelBOList;



}
