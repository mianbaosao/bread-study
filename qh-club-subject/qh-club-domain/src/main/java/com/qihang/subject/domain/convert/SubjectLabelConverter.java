package com.qihang.subject.domain.convert;



 import com.qihang.subject.domain.entity.SubjectLabelBO;
 import com.qihang.subject.infrastructure.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

/**
 * @Description: 题目标签BO转PO
 * @Author:bread
 * @Date: 2024-08-21 17:38
 */
@Mapper
public interface SubjectLabelConverter {
    SubjectLabelConverter INSTANCE= Mappers.getMapper(SubjectLabelConverter.class);

    SubjectLabel converBoToLabel(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> convertBoToLLabel(List<SubjectLabel> LabelList);

}
