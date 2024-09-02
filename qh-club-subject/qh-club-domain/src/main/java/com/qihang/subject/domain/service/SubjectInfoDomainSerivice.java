package com.qihang.subject.domain.service;

import com.qihang.subject.domain.entity.SubjectInfoBO;

/**
 * @Description: 题目信息
 * @Author:bread
 * @Date: 2024-08-26 17:09
 */
public interface SubjectInfoDomainSerivice {
    /**
     * 新增题目
     * @param subjectInfoBO
     * @return
     */
    void add(SubjectInfoBO subjectInfoBO);
}
