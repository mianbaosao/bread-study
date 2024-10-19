package com.mianbao.forum.common.handler.recommend;

import com.mianbao.forum.common.entity.BlogDataBO;
import com.study.forum.common.enums.RecommendAlgorithm;

/**
 * @Description: 推荐算法接口
 * @Author:bread
 * @Date: 2024-10-18 20:00
 */
public interface RecommendType {
    RecommendAlgorithm getType();
    /**
     * 查询相关博客内容
     */
    BlogDataBO query(int userId);
}
