package com.qihang.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.qihang.subject.domain.convert.SubjectInfoConverter;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.domain.handler.subject.factory.SubjectHandlerTypeFactory;
import com.qihang.subject.domain.handler.subject.SubjectTypeHandler;
import com.qihang.subject.domain.service.SubjectInfoDomainSerivice;
import com.qihang.subject.infrastructure.basic.entity.SubjectInfo;
import com.qihang.subject.infrastructure.basic.entity.SubjectMapping;
import com.qihang.subject.infrastructure.basic.service.SubjectInfoService;
import com.qihang.subject.infrastructure.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 题目信息
 * @Author:bread
 * @Date: 2024-08-26 17:11
 */
@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainSerivice {
    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectHandlerTypeFactory subjectHandlerTypeFactory;

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        //工厂模式：一个工厂对应四个题目类型，根据传入的type进行自动映射选择
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.converBoToInfo(subjectInfoBO);
        subjectInfoService.insert(subjectInfo);
        SubjectTypeHandler handler=subjectHandlerTypeFactory.getHandler(subjectInfo.getSubjectType());
        handler.add(subjectInfoBO);

        List<SubjectMapping>subjectMappingList=new LinkedList<>();
        List<Long> categoryIds = subjectInfoBO.getCategoryIds();
        List<Long> labelIds = subjectInfoBO.getLabelIds();
        categoryIds.forEach(categoryId->{
            labelIds.forEach(labelId->{
                SubjectMapping subjectMapping=new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(categoryId);
                subjectMapping.setLabelId(labelId);
                subjectMappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(subjectMappingList);
    }
}
