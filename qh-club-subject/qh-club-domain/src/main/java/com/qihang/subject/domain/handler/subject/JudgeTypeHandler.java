package com.qihang.subject.domain.handler.subject;

import com.google.common.base.Preconditions;
import com.qihang.subject.common.enums.SubjectInfoTypeEnum;
import com.qihang.subject.domain.convert.JudgeSubejectConverter;
import com.qihang.subject.domain.convert.RadioSubjectConverter;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectJudge;
import com.qihang.subject.infrastructure.basic.entity.SubjectRadio;
import com.qihang.subject.infrastructure.basic.service.SubjectJudgeService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 判断策略类
 * @Author:bread
 * @Date: 2024-08-26 17:34
 */
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
}
