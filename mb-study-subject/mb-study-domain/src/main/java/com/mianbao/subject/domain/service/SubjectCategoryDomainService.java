package com.mianbao.subject.domain.service;

import com.mianbao.subject.domain.entity.SubjectCategoryBO;

import java.util.List;

/**
 * @Description: 分类接口
 * @Author:bread
 * @Date: 2024-07-30 9:33
 */
public interface SubjectCategoryDomainService {


    /**
     * 新增分类
     */
    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * 查询分类
     * @return
     */
    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * 更新分类
     * @param subjectCategoryBO
     * @return
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);

    /**
     * 删除分类
     * @param subjectCategoryBO
     * @return
     */
    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
