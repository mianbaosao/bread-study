package com.study.forum.common.enums;

/**
 * @Description: 博客内容推荐算法枚举类
 * @Author:bread
 * @Date: 2024-10-18 19:31
 */
public enum RecommendAlgorithm {

    // 定义枚举常量，每个常量包含code和desc
    COLLABORATIVE_FILTERING("CF", "协同过滤推荐算法 - 适用于活跃用户，根据历史行为数据推荐相似内容"),
    CONTENT_BASED("CB", "基于内容的推荐算法 - 适用于新用户或兴趣集中用户，根据内容特征推荐相似内容"),
    POPULARITY_BASED("PB", "热门推荐算法 - 适用于不活跃用户，推荐社区中的热门内容");

    private final String code;  // 算法代码
    private final String desc;  // 算法描述

    // 构造方法
    RecommendAlgorithm(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static RecommendAlgorithm getByCode(String type) {
        for(RecommendAlgorithm recommendAlgorithm:RecommendAlgorithm.values()){
            if(recommendAlgorithm.code.equals(type)){
                return recommendAlgorithm;
            }
        }
        return null;
    }

    // 获取算法代码
    public String getCode() {
        return code;
    }

    // 获取算法描述
    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return String.format("Algorithm: %s, Description: %s", code, desc);
    }
}

