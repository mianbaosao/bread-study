package com.mianbao.subject.domain.handler.subject;


import com.mianbao.subject.common.enums.SubjectInfoTypeEnum;
import com.mianbao.subject.domain.entity.SubjectInfoBO;
import com.mianbao.subject.domain.entity.SubjectOptionBO;



/**
 * @Description: 题目类型
 * @Author:bread
 * @Date: 2024-08-26 17:29
 */
public interface SubjectTypeHandler {
    SubjectInfoTypeEnum getHandlerType();

    /**
     * 实际的题目增加
     */
    void add(SubjectInfoBO subjectInfoBO);

    SubjectOptionBO query(int subjectId);
}
