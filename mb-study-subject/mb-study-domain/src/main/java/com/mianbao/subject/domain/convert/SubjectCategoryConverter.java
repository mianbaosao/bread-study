package com.mianbao.subject.domain.convert;

import com.mianbao.subject.domain.entity.SubjectCategoryBO;
import com.mianbao.subject.infrastructure.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import java.util.List;

/**
 * @Description: 实体类转换
 * @Author:bread
 * @Date: 2024-07-30 9:36
 */
@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE = Mappers.getMapper(SubjectCategoryConverter.class);

    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);

    List<SubjectCategoryBO> convertBoToCategory(List<SubjectCategory> categoryList);

}
