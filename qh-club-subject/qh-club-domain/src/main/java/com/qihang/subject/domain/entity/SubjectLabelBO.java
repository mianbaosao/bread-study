package com.qihang.subject.domain.entity;

import lombok.Data;

/**
 * @Description: 题目标签BO
 * @Author:bread
 * @Date: 2024-08-21 17:26
 */
@Data
public class SubjectLabelBO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 分类id
     */
    private Long categoryId;
}
