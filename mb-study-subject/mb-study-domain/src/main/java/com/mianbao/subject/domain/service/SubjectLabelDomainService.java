package com.mianbao.subject.domain.service;

import com.mianbao.subject.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * @Description: 题目标签
 * @Author:bread
 * @Date: 2024-08-21 17:31
 */
public interface SubjectLabelDomainService {

    /**
     * 新增标签
     * @param subjectLabelBO
     */
    Boolean add(SubjectLabelBO subjectLabelBO);

    /**
     * 更新分类
     * @param subjectLabelBO
     * @return
     */
    Boolean update(SubjectLabelBO subjectLabelBO);

    /**
     * 删除标签
     * @param subjectLabelBO
     * @return
     */
    Boolean delete(SubjectLabelBO subjectLabelBO);

    /**
     * 根据分类id查询标签
     * @param subjectLabelBO
     * @return
     */
    List<SubjectLabelBO> queryByCategoryId(SubjectLabelBO subjectLabelBO);
}
