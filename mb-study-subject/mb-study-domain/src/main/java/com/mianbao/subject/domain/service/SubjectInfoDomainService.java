package com.mianbao.subject.domain.service;


import com.mianbao.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.common.entity.PageResult;

/**
 * @Description: 题目信息
 * @Author:bread
 * @Date: 2024-08-26 17:09
 */
public interface SubjectInfoDomainService {
    /**
     * 新增题目
     * @param subjectInfoBO
     * @return
     */
    void add(SubjectInfoBO subjectInfoBO);

    /**
     * 分页查询
     * @param subjectInfoBO
     * @return
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);

    /**
     * 查看题目信息
     * @param subjectInfoBO
     * @return
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);
}
