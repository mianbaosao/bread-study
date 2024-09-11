package com.mianbao.subject.application.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 题目标签dto
 * @Author:bread
 * @Date: 2024-08-21 17:19
 */
@Data
public class SubjectLabelDTO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 标签分类
     */
    private String labelName;
    /**
     * 分类id
     */
    private Long categoryId;
    /**
     * 排序
     */
    private Integer sortNum;

}
