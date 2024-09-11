package com.mianbao.subject.application.convert;

import com.mianbao.subject.application.dto.SubjectInfoDTO;
import com.mianbao.subject.domain.entity.SubjectInfoBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * @Description: 题目信息实体类转化
 * @Author:bread
 * @Date: 2024-08-21 17:22
 */
@Mapper
public interface SubjectInfoDTOConverter {
    //单例实例,通过这种方式，可以直接调用接口中的方法，而无需手动实例化实现类。
    SubjectInfoDTOConverter INSTANCE = Mappers.getMapper(SubjectInfoDTOConverter.class);
    //将一个 SubjectLabelBO 对象列表转换为一个 SubjectLabelDTO 对象列表
    List<SubjectInfoDTO> convertBoToLabelDTOList(List<SubjectInfoBO> subjectInfoBOS);
    //将一个 SubjectLabelDTO 对象转换为一个 SubjectLabelBO 对象。
    SubjectInfoBO convertDtoToInfoBO(SubjectInfoDTO subjectInfoDTO);

    SubjectInfoDTO convertBoToInfoDTO(SubjectInfoBO subjectInfoBO);

    List<SubjectInfoBO> convertDTOToBOList(List<SubjectInfoDTO> subjectInfoDTOS);
}
