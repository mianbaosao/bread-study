package com.mianbao.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;

import com.mianbao.subject.domain.convert.SubjectLabelConverter;
import com.mianbao.subject.domain.entity.SubjectLabelBO;
import com.mianbao.subject.domain.service.SubjectLabelDomainService;
import com.mianbao.subject.infrastructure.basic.entity.SubjectLabel;
import com.mianbao.subject.infrastructure.basic.entity.SubjectMapping;
import com.mianbao.subject.infrastructure.basic.service.SubjectLabelService;
import com.mianbao.subject.infrastructure.basic.service.SubjectMappingService;
import com.qihang.subject.common.enums.IsDeleteEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 题目标签
 * @Author:bread
 * @Date: 2024-08-21 17:31
 */
@Service
@Slf4j
public class SubjectLabelDomainServiceImpl implements SubjectLabelDomainService {

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingService;

    /**
     * 新增标签
     * @param subjectLabelBO
     */
    @Override
    public Boolean add(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelController.add.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.converBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteEnum.UN_DELETED.getCode());
      int cnt = subjectLabelService.insert(subjectLabel);
      return cnt>0;
    }

    @Override
    public Boolean update(SubjectLabelBO subjectLabelBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectLabelController.update.bo:{}", JSON.toJSONString(subjectLabelBO));
        }
        SubjectLabel subjectLabel = SubjectLabelConverter.INSTANCE.converBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteEnum.UN_DELETED.getCode());
        int cnt = subjectLabelService.update(subjectLabel);
        return cnt>0;
    }

    @Override
    public Boolean delete(SubjectLabelBO subjectLabelBO) {
        SubjectLabel subjectLabel=SubjectLabelConverter.INSTANCE
                .converBoToLabel(subjectLabelBO);
        subjectLabel.setIsDeleted(IsDeleteEnum.DELETED.getCode());
        return subjectLabelService.deleteById(subjectLabel.getId());
    }


    @Override
    public List<SubjectLabelBO> queryByCategoryId(SubjectLabelBO subjectLabelBO) {
        Long categoryId=subjectLabelBO.getCategoryId();
        SubjectMapping subjectMapping=new SubjectMapping();
        subjectMapping.setCategoryId(categoryId);
        subjectMapping.setIsDeleted(IsDeleteEnum.UN_DELETED.getCode());
        List<SubjectMapping> subjectMappings=subjectMappingService.queryLabelIdListById(subjectMapping);
        if(CollectionUtils.isEmpty(subjectMappings)){
            return Collections.emptyList();
        }
        List<Long>LabelIds=subjectMappings.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> subjectLabelList=subjectLabelService.batchQueryById(LabelIds);
        List<SubjectLabelBO> subjectLabelBOList=new LinkedList<>();
       subjectLabelList.forEach(Label->{
           SubjectLabelBO bo=new SubjectLabelBO();
           bo.setId(Label.getId());
           bo.setCategoryId(categoryId);
           bo.setLabelName(Label.getLabelName());
           bo.setSortNum(Label.getSortNum());
           subjectLabelBOList.add(bo);
       });
        return subjectLabelBOList;
    }
}
