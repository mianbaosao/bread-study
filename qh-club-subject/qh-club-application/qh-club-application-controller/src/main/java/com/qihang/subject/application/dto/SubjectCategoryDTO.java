package com.qihang.subject.application.dto;

import java.io.Serializable;

/**
 * @Description: dto
 * @Author:bread
 * @Date: 2024-07-29 19:45
 */

public class SubjectCategoryDTO implements Serializable {

    private Long id;
    private String categoryName;
    private Integer categoryType;
    private String imageUrl;
    private Long parentId;

    public SubjectCategoryDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Integer getCategoryType() {
        return this.categoryType;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }


    public String toString() {
        return "SubjectCategoryDTO(id=" + this.getId() + ", categoryName=" + this.getCategoryName() + ", categoryType=" + this.getCategoryType() + ", imageUrl=" + this.getImageUrl() + ", parentId=" + this.getParentId() + ")";
    }
}