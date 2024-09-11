package com.mianbao.subject.domain.convert;


import com.mianbao.subject.domain.entity.SubjectAnswerBO;
import com.mianbao.subject.domain.entity.SubjectOptionBO;
import com.mianbao.subject.domain.entity.SubjectInfoBO;
import com.mianbao.subject.infrastructure.basic.entity.SubjectInfo;
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
