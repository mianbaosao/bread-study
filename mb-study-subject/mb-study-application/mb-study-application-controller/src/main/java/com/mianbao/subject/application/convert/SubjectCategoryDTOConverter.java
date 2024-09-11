package com.mianbao.subject.application.convert;

import com.mianbao.subject.application.dto.SubjectCategoryDTO;
import com.mianbao.subject.domain.entity.SubjectCategoryBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description: 题目分类dto转换器
 * @Author:bread
 * @Date: 2024-07-30 9:40
 */

@Mapper
public interface SubjectCategoryDTOConverter {

    //单例实例,通过这种方式，可以直接调用接口中的方法，而无需手动实例化实现类。
    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);
    //将一个 SubjectCategoryBO 对象列表转换为一个 SubjectCategoryDTO 对象列表
    List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryDTO);
    //将一个 SubjectCategoryDTO 对象转换为一个 SubjectCategoryBO 对象。
     SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO);

    SubjectCategoryDTO convertBoToCategoryDTO(SubjectCategoryBO subjectCategoryBO);

}
