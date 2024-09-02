package com.qihang.subject.domain.handler.subject;

import com.google.common.base.Preconditions;
import com.qihang.subject.common.enums.SubjectInfoTypeEnum;
import com.qihang.subject.domain.convert.RadioSubjectConverter;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectRadio;
import com.qihang.subject.infrastructure.basic.service.SubjectRadioService;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 单选的策略类
 * @Author:bread
 * @Date: 2024-08-26 17:32
 */
public class RadioTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectRadioService subjectRadioService;
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        //单选题目的插入
        List<SubjectRadio> subjectRadioList=new LinkedList<>();
        Preconditions.checkNotNull(!CollectionUtils.isEmpty(subjectInfoBO.getOptionList()),"列表不能为空");

        subjectInfoBO.getOptionList().forEach(option->{
            SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.converBoToRadio(option);
            subjectRadio.setSubjectId(subjectInfoBO.getId());
            subjectRadioList.add(subjectRadio);
        });
        subjectRadioService.batchInsert(subjectRadioList);
    }
}
