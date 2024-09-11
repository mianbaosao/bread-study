package com.mianbao.subject.domain.handler.subject;

import com.google.common.base.Preconditions;

import com.mianbao.subject.domain.convert.JudgeSubejectConverter;
import com.mianbao.subject.domain.entity.SubjectAnswerBO;
import com.mianbao.subject.domain.entity.SubjectInfoBO;
import com.mianbao.subject.domain.entity.SubjectOptionBO;

import com.mianbao.subject.infrastructure.basic.entity.SubjectJudge;

import com.mianbao.subject.infrastructure.basic.service.SubjectJudgeService;
import com.qihang.subject.common.enums.SubjectInfoTypeEnum;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 判断策略类
 * @Author:bread
 * @Date: 2024-08-26 17:34
 */
@Component
public class JudgeTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectJudgeService subjectJudgeService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //判断题目的插入
        List<SubjectJudge> subjectJudgeList=new LinkedList<>();
        Preconditions.checkNotNull(!CollectionUtils.isEmpty(subjectInfoBO.getOptionList()),"列表不能为空");

        subjectInfoBO.getOptionList().forEach(option->{
            SubjectJudge subjectJudge = JudgeSubejectConverter.INSTANCE.converAnswerBoToJudge(option);
            subjectJudge.setSubjectId(subjectInfoBO.getId());
            subjectJudgeList.add(subjectJudge);
        });
        subjectJudgeService.batchInsert(subjectJudgeList);
    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(Long.valueOf(subjectId));
        List<SubjectJudge> result = subjectJudgeService.queryByCondition(subjectJudge);
        List<SubjectAnswerBO> subjectAnswerBOList = JudgeSubejectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }
}
