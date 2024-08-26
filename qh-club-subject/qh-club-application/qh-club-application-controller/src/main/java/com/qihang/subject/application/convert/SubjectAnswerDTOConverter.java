package com.qihang.subject.application.convert;

import com.qihang.subject.application.dto.SubjectAnswerDTO;
import com.qihang.subject.application.dto.SubjectInfoDTO;
import com.qihang.subject.domain.entity.SubjectAnswerBO;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 题目信息实体类转化
 * @Author:bread
 * @Date: 2024-08-21 17:22
 */
@Mapper
public interface SubjectAnswerDTOConverter {
    //单例实例,通过这种方式，可以直接调用接口中的方法，而无需手动实例化实现类。
    SubjectAnswerDTOConverter INSTANCE = Mappers.getMapper(SubjectAnswerDTOConverter.class);
    //将一个 SubjectLabelBO 对象列表转换为一个 SubjectLabelDTO 对象列表
    List<SubjectAnswerDTO> convertBoToLabelDTOList(List<SubjectAnswerBO> subjectAnswerBOS);
    //将一个 SubjectLabelDTO 对象转换为一个 SubjectLabelBO 对象。
    SubjectAnswerBO convertDtoToInfoBO(SubjectAnswerDTO subjectAnswerDTO);

    SubjectAnswerDTO convertBoToInfoDTO(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> convertDTOToBOList(List<SubjectAnswerDTO> subjectAnswerDTOS);
}
