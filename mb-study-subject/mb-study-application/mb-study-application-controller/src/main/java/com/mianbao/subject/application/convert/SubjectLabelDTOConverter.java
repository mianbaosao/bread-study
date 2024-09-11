package com.mianbao.subject.application.convert;

import com.mianbao.subject.application.dto.SubjectLabelDTO;
import com.mianbao.subject.domain.entity.SubjectLabelBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 题目标签实体类转化
 * @Author:bread
 * @Date: 2024-08-21 17:22
 */
@Mapper
public interface SubjectLabelDTOConverter {
    //单例实例,通过这种方式，可以直接调用接口中的方法，而无需手动实例化实现类。
    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);
    //将一个 SubjectLabelBO 对象列表转换为一个 SubjectLabelDTO 对象列表
    List<SubjectLabelDTO> convertBoToLabelDTOList(List<SubjectLabelBO> subjectLabelDTO);
    //将一个 SubjectLabelDTO 对象转换为一个 SubjectLabelBO 对象。
    SubjectLabelBO convertDtoToLabelBO(SubjectLabelDTO subjectLabelDTO);

    SubjectLabelDTO convertBoToLabelDTO(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> convertDTOToBOList(List<SubjectLabelDTO> subjectLabelDTOList);
}
