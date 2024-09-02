package com.qihang.subject.domain.handler.subject;

import com.google.common.base.Preconditions;
import com.qihang.subject.common.enums.SubjectInfoTypeEnum;
import com.qihang.subject.domain.convert.RadioSubjectConverter;
import com.qihang.subject.domain.convert.SubjectInfoConverter;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectInfo;
import com.qihang.subject.infrastructure.basic.entity.SubjectRadio;
import com.qihang.subject.infrastructure.basic.service.SubjectInfoService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 简答策略类
 * @Author:bread
 * @Date: 2024-08-26 17:34
 */
public class BriefTypeHandler implements SubjectTypeHandler{
    @Resource
    private SubjectInfoService subjectInfoService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //简答
        //简答的插入
        List<SubjectInfo> subjectInfoList=new LinkedList<>();
        Preconditions.checkNotNull(!CollectionUtils.isEmpty(subjectInfoBO.getOptionList()),"列表不能为空");

        subjectInfoBO.getOptionList().forEach(option->{
            SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.converAnserBoToInfo(option);
            subjectInfoList.add(subjectInfo);
        });
        subjectInfoService.batchInsert(subjectInfoList);
    }
}
