package com.qihang.subject.domain.convert;

import com.qihang.subject.domain.entity.SubjectAnswerBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: 判断题题转化
 * @Author:bread
 * @Date: 2024-09-02 15:21
 */
@Mapper
public interface JudgeSubejectConverter {
    JudgeSubejectConverter INSTANCE= Mappers.getMapper(JudgeSubejectConverter.class);

    SubjectJudge converAnswerBoToJudge(SubjectAnswerBO subjectAnswerBO);
}
