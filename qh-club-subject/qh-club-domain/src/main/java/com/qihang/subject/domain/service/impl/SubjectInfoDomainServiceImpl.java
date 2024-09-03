package com.qihang.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.qihang.subject.common.entity.PageResult;
import com.qihang.subject.common.enums.IsDeleteEnum;
import com.qihang.subject.domain.convert.SubjectInfoConverter;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.domain.entity.SubjectOptionBO;
import com.qihang.subject.domain.handler.subject.SubjectHandlerTypeFactory;
import com.qihang.subject.domain.handler.subject.SubjectTypeHandler;
import com.qihang.subject.domain.service.SubjectInfoDomainService;
import com.qihang.subject.infrastructure.basic.entity.SubjectInfo;
import com.qihang.subject.infrastructure.basic.entity.SubjectLabel;
import com.qihang.subject.infrastructure.basic.entity.SubjectMapping;
import com.qihang.subject.infrastructure.basic.service.SubjectInfoService;
import com.qihang.subject.infrastructure.basic.service.SubjectLabelService;
import com.qihang.subject.infrastructure.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 题目信息
 * @Author:bread
 * @Date: 2024-08-26 17:11
 */
@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {
    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectLabelService subjectLabelService;
    @Resource
    private SubjectMappingService subjectMappingService;
    @Resource
    private SubjectHandlerTypeFactory subjectHandlerTypeFactory;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBO subjectInfoBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        //工厂模式：一个工厂对应四个题目类型，根据传入的type进行自动映射选择
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.converBoToInfo(subjectInfoBO);
        subjectInfo.setIsDeleted(IsDeleteEnum.UN_DELETED.getCode());
        subjectInfoService.insert(subjectInfo);
        SubjectTypeHandler handler=subjectHandlerTypeFactory.getHandler(subjectInfo.getSubjectType());
        subjectInfoBO.setId(subjectInfo.getId());
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
                subjectMapping.setIsDeleted(IsDeleteEnum.UN_DELETED.getCode());
                subjectMappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(subjectMappingList);
    }

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.converBoToInfo(subjectInfoBO);
        int count = subjectInfoService.countByCondition(subjectInfo, subjectInfoBO.getCategoryId(), subjectInfoBO.getLabelId());
        if(count==0){
            return pageResult;
        }
       List<SubjectInfo> subjectInfoList =  subjectInfoService.queryPage(subjectInfo,
                subjectInfoBO.getCategoryId(),
                subjectInfoBO.getLabelId(),
                start,
                subjectInfoBO.getPageSize()
                );
        List<SubjectInfoBO> subjectInfoBOList = SubjectInfoConverter.INSTANCE.convertBoToLInfo(subjectInfoList);
        pageResult.setResult(subjectInfoBOList);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {
        SubjectInfo subjectInfo = subjectInfoService.queryById(subjectInfoBO.getId());
        SubjectTypeHandler handler = subjectHandlerTypeFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO optionBO = handler.query(subjectInfo.getId().intValue());
        SubjectInfoBO bo = SubjectInfoConverter.INSTANCE.convertOptionAndInfoToBo(optionBO, subjectInfo);
        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfo.getId());
        subjectMapping.setIsDeleted(IsDeleteEnum.UN_DELETED.getCode());
        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> labelIdList = mappingList.stream().map(SubjectMapping::getLabelId).collect(Collectors.toList());
        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<String> labelNameList = labelList.stream().map(SubjectLabel::getLabelName).collect(Collectors.toList());
        bo.setLabelName(labelNameList);
        return bo;
    }
}
