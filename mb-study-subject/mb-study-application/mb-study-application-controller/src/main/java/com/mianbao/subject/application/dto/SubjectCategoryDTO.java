package com.mianbao.subject.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: dto
 * @Author:bread
 * @Date: 2024-07-29 19:45
 */
@Data
public class SubjectCategoryDTO implements Serializable {

    private Long id;
    private String categoryName;
    private Integer categoryType;
    private String imageUrl;
    private Long parentId;

    /**
     * 标签信息
     */
    private List<SubjectLabelDTO> labelDTOList;
}