package com.mianbao.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;

import com.mianbao.subject.domain.convert.SubjectCategoryConverter;
import com.mianbao.subject.domain.entity.SubjectCategoryBO;
import com.mianbao.subject.domain.service.SubjectCategoryDomainService;
import com.mianbao.subject.infrastructure.basic.entity.SubjectCategory;
import com.mianbao.subject.infrastructure.basic.service.SubjectCategoryService;
import com.qihang.subject.common.enums.IsDeleteEnum;
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
        subjectCategory.setIsDeleted(IsDeleteEnum.UN_DELETED.getCode());
        subjectCategoryService.insert(subjectCategory);
    }

    /**
     * 查询分类
     * @return
     */
    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory=SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeleteEnum.UN_DELETED.getCode());
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);
        List<SubjectCategoryBO> boList=SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryList);

        return boList;
    }

    /**
     * 更新分类
     * @param subjectCategoryBO
     * @return
     */
    @Override
    public Boolean update(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory=SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        int updateState=subjectCategoryService.update(subjectCategory);
        return updateState > 0;
    }

    /**
     * 删除分类
     * @param subjectCategoryBO
     * @return
     */
    @Override
    public Boolean delete(SubjectCategoryBO subjectCategoryBO) {
        SubjectCategory subjectCategory=SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);
        subjectCategory.setIsDeleted(IsDeleteEnum.DELETED.getCode());
        return subjectCategoryService.deleteById(subjectCategory.getId());
    }

}
