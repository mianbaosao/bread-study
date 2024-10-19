package com.mianbao.forum.common.handler.recommend;

import com.mianbao.forum.common.entity.BlogDataBO;
import com.study.forum.common.enums.RecommendAlgorithm;
import org.springframework.stereotype.Component;

/**
 * @Description: 基于内容的推荐算法
 * @Author:bread
 * @Date: 2024-10-18 20:32
 */
@Component
public class CBAlgorithem implements RecommendType{
    @Override
    public RecommendAlgorithm getType() {
        return RecommendAlgorithm.COLLABORATIVE_FILTERING;
    }

    @Override
    public BlogDataBO query(int userId) {
        System.out.println("CB成功");
        return null;
    }
}
