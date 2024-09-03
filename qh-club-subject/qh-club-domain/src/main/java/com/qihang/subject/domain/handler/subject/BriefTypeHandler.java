package com.qihang.subject.domain.handler.subject;

import com.google.common.base.Preconditions;
import com.qihang.subject.common.enums.IsDeleteEnum;
import com.qihang.subject.common.enums.SubjectInfoTypeEnum;
import com.qihang.subject.domain.convert.BriefSubjectConverter;
import com.qihang.subject.domain.convert.RadioSubjectConverter;
import com.qihang.subject.domain.convert.SubjectInfoConverter;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.domain.entity.SubjectOptionBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectBrief;
import com.qihang.subject.infrastructure.basic.entity.SubjectInfo;
import com.qihang.subject.infrastructure.basic.entity.SubjectRadio;
import com.qihang.subject.infrastructure.basic.service.SubjectBriefService;
import com.qihang.subject.infrastructure.basic.service.SubjectInfoService;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 简答策略类
 * @Author:bread
 * @Date: 2024-08-26 17:34
 */
@Component
public class BriefTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectBriefService subjectBriefService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId().intValue());
        subjectBrief.setIsDeleted(IsDeleteEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectBrief subjectBrief = new SubjectBrief();
        subjectBrief.setSubjectId(subjectId);
        SubjectBrief result = subjectBriefService.queryByCondition(subjectBrief);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setSubjectAnswer(result.getSubjectAnswer());
        return subjectOptionBO;
    }
}
