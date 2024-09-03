package com.qihang.subject.domain.convert;


import com.qihang.subject.domain.entity.SubjectAnswerBO;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.domain.entity.SubjectLabelBO;
import com.qihang.subject.domain.entity.SubjectOptionBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectInfo;
import com.qihang.subject.infrastructure.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 题目BO转PO
 * @Author:bread
 * @Date: 2024-08-21 17:38
 */
@Mapper
public interface SubjectInfoConverter {
    SubjectInfoConverter INSTANCE= Mappers.getMapper(SubjectInfoConverter.class);

    SubjectInfo converBoToInfo(SubjectInfoBO subjectInfoBO);

    SubjectInfo converAnserBoToInfo(SubjectAnswerBO subjectAnswerBO);

    List<SubjectInfoBO> convertBoToLInfo(List<SubjectInfo> infoList);

    SubjectInfoBO convertOptionAndInfoToBo(SubjectOptionBO subjectOptionBO, SubjectInfo subjectInfo);
}
