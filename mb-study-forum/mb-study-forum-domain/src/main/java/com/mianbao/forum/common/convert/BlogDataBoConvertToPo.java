package com.mianbao.forum.common.convert;

import com.mianbao.forum.common.entity.BlogDataBO;
import com.mianbao.forum.infa.basic.entity.ForumBlogdata;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description: bo->po
 * @Author:bread
 * @Date: 2024-10-17 19:29
 */
@Mapper
public interface BlogDataBoConvertToPo {
    BlogDataBoConvertToPo INSTANCE = Mappers.getMapper(BlogDataBoConvertToPo.class);

    ForumBlogdata BlogDataTOPo (BlogDataBO blogDataBO);
}
