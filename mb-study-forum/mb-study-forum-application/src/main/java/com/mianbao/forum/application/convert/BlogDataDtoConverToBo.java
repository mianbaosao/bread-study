package com.mianbao.forum.application.convert;


import com.mianbao.forum.application.dto.BlogDataDTO;
import com.mianbao.forum.common.entity.BlogDataBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: dto->bo
 * @Author:bread
 * @Date: 2024-10-17 19:15
 */
@Mapper
public interface BlogDataDtoConverToBo {
    BlogDataDtoConverToBo INSTANCE = Mappers.getMapper(BlogDataDtoConverToBo.class);

    BlogDataBO converBlogDataDtoToBo(BlogDataDTO blogDataDTO);

}
