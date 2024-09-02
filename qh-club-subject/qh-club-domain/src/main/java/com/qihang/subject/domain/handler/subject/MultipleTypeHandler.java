package com.qihang.subject.domain.handler.subject;

import com.google.common.base.Preconditions;
import com.qihang.subject.common.enums.SubjectInfoTypeEnum;
import com.qihang.subject.domain.convert.JudgeSubejectConverter;
import com.qihang.subject.domain.convert.MultipleSubejectConverter;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectJudge;
import com.qihang.subject.infrastructure.basic.entity.SubjectMultiple;
import com.qihang.subject.infrastructure.basic.service.SubjectMultipleService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 多选策略类
 * @Author:bread
 * @Date: 2024-08-26 17:34
 */
public class MultipleTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectMultipleService subjectMultipleService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //多选
        List<SubjectMultiple> subjectMultipleList=new LinkedList<>();
        Preconditions.checkNotNull(!CollectionUtils.isEmpty(subjectInfoBO.getOptionList()),"列表不能为空");

        subjectInfoBO.getOptionList().forEach(option->{
            SubjectMultiple subjectMultiple = MultipleSubejectConverter.INSTANCE.converAnswerBoToJudge(option);
            subjectMultiple.setSubjectId(subjectInfoBO.getId());
            subjectMultipleList.add(subjectMultiple);
        });
        subjectMultipleService.batchInsert(subjectMultipleList);
    }
}
