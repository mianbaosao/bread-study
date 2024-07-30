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


    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.add.bo:{}", JSON.toJSONString(subjectCategoryBO));
        }
        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);

        subjectCategoryService.insert(subjectCategory);
    }

}
