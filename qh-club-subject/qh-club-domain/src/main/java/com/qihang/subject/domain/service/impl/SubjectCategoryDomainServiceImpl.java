package com.qihang.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.qihang.subject.domain.convert.SubjectCategoryConverter;
import com.qihang.subject.domain.entity.SubjectCategoryBO;
import com.qihang.subject.domain.service.SubjectCategoryDomainService;
import com.qihang.subject.infrastructure.basic.entity.SubjectCategory;
import com.qihang.subject.infrastructure.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 刷题分类实现类
 * @Author:bread
 * @Date: 2024-07-30 9:46
 */
@Service
@Slf4j
public class SubjectCategoryDomainServiceImpl implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    /**
     * 新增分类
     * @param subjectCategoryBO
     */
    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);

        subjectCategoryService.insert(subjectCategory);
    }

    /**
     * 查询分类
     * @return
     */
    @Override
    public List<SubjectCategoryBO> queryPrimaryCategory() {
        List<SubjectCategory> subjectCategories = subjectCategoryService.queryPrimaryCategory();
        List<SubjectCategoryBO> subjectCategoryBOS=SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategories);

        return subjectCategoryBOS;
    }

}
