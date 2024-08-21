package com.qihang.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.qihang.subject.common.enums.IsDeleteEnum;
import com.qihang.subject.domain.convert.SubjectCategoryConverter;
import com.qihang.subject.domain.convert.SubjectLabelConverter;
import com.qihang.subject.domain.entity.SubjectLabelBO;
import com.qihang.subject.domain.service.SubjectLabelDomainService;
import com.qihang.subject.infrastructure.basic.entity.SubjectCategory;
import com.qihang.subject.infrastructure.basic.entity.SubjectLabel;
import com.qihang.subject.infrastructure.basic.service.SubjectLabelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
