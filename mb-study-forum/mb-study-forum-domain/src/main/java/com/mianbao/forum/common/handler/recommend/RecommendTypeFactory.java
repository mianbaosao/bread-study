package com.mianbao.forum.common.handler.recommend;

import com.mianbao.forum.common.entity.BlogDataBO;
import com.study.forum.common.enums.RecommendAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 工厂
 * @Author:bread
 * @Date: 2024-10-18 20:17
 */
@Component
public class RecommendTypeFactory implements InitializingBean {
    @Resource
    private List<RecommendType> recommendTypeList;

    private Map<RecommendAlgorithm,RecommendType> recommendTypeMap=new HashMap<>();

    public RecommendType getType(String type) {
        RecommendAlgorithm recommendAlgorithm=RecommendAlgorithm.getByCode(type);
        return recommendTypeMap.get(recommendAlgorithm);
    }

    /**
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        for(RecommendType RecommendType:recommendTypeList){
            recommendTypeMap.put(RecommendType.getType(),RecommendType);
        }
    }
}
