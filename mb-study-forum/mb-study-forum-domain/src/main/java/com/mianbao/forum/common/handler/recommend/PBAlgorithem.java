package com.mianbao.forum.common.handler.recommend;

import com.mianbao.forum.common.entity.BlogDataBO;
import com.study.forum.common.enums.RecommendAlgorithm;

/**
 * @Description: 热门推荐算法
 * @Author:bread
 * @Date: 2024-10-18 20:33
 */

public class PBAlgorithem implements RecommendType{
    @Override
    public RecommendAlgorithm getType() {
        return RecommendAlgorithm.POPULARITY_BASED;
    }

    @Override
    public BlogDataBO query(int userId) {
        System.out.println("CB成功");
        return null;
    }
}
