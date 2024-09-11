package com.mianbao.subject.domain.convert;

import com.mianbao.subject.domain.entity.SubjectAnswerBO;
import com.mianbao.subject.infrastructure.basic.entity.SubjectJudge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 判断题题转化
 * @Author:bread
 * @Date: 2024-09-02 15:21
 */
@Mapper
public interface JudgeSubejectConverter {
    JudgeSubejectConverter INSTANCE= Mappers.getMapper(JudgeSubejectConverter.class);

    SubjectJudge converAnswerBoToJudge(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectJudge> subjectJudgeList);

}
