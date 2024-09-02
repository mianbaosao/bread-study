package com.qihang.subject.domain.convert;

import com.qihang.subject.domain.entity.SubjectAnswerBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectJudge;
import com.qihang.subject.infrastructure.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: 多选题转化
 * @Author:bread
 * @Date: 2024-09-02 15:21
 */
@Mapper
public interface MultipleSubejectConverter {
    MultipleSubejectConverter INSTANCE= Mappers.getMapper(MultipleSubejectConverter.class);

    SubjectMultiple converAnswerBoToJudge(SubjectAnswerBO subjectAnswerBO);
}
