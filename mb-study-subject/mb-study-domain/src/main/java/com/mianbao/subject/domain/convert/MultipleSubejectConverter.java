package com.mianbao.subject.domain.convert;

import com.mianbao.subject.domain.entity.SubjectAnswerBO;
import com.mianbao.subject.infrastructure.basic.entity.SubjectMultiple;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 多选题转化
 * @Author:bread
 * @Date: 2024-09-02 15:21
 */
@Mapper
public interface MultipleSubejectConverter {
    MultipleSubejectConverter INSTANCE= Mappers.getMapper(MultipleSubejectConverter.class);

    SubjectMultiple converAnswerBoToJudge(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectMultiple> subjectMultipleList);
}
