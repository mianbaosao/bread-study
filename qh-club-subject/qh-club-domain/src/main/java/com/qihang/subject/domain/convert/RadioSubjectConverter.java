package com.qihang.subject.domain.convert;


import com.qihang.subject.domain.entity.SubjectAnswerBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectRadio;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 单选题目BO转PO
 * @Author:bread
 * @Date: 2024-08-21 17:38
 */
@Mapper
public interface RadioSubjectConverter {
    RadioSubjectConverter INSTANCE= Mappers.getMapper(RadioSubjectConverter.class);

    SubjectRadio converBoToRadio(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectRadio> subjectRadioList);

}
