package com.qihang.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.qihang.subject.application.convert.SubjectAnswerDTOConverter;
import com.qihang.subject.application.convert.SubjectInfoDTOConverter;
import com.qihang.subject.application.convert.SubjectLabelDTOConverter;
import com.qihang.subject.application.dto.SubjectInfoDTO;
import com.qihang.subject.application.dto.SubjectLabelDTO;
import com.qihang.subject.common.entity.Result;
import com.qihang.subject.domain.entity.SubjectAnswerBO;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.domain.entity.SubjectLabelBO;
import com.qihang.subject.domain.service.SubjectCategoryDomainService;
import com.qihang.subject.domain.service.SubjectInfoDomainSerivice;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 题目控制层
 * @Author:bread
 * @Date: 2024-08-26 16:12
 */
@RestController
@RequestMapping
@Slf4j
public class SubjectController {

    @Resource
    private SubjectInfoDomainSerivice subjectInfoDomainSerivice;
    /**
     * 新增题目
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectInfoDTO subjectInfoDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectController.add.dto:{}", JSON.toJSONString(subjectInfoDTO));
            }
            // StringUtils.isBlank来检查字符串是否为空白，StringUtils.isBlank 会返回 true 如果字符串为 null
            Preconditions.checkArgument(!StringUtils.isBlank(subjectInfoDTO.getSubjectName()), "题目名称不能为空");
            Preconditions.checkNotNull(subjectInfoDTO.getSubjectType(), "题目类型不能为空");
            Preconditions.checkNotNull(!CollectionUtils.isEmpty(subjectInfoDTO.getCategoryIds()),"分类id不能为空");
            Preconditions.checkNotNull(!CollectionUtils.isEmpty(subjectInfoDTO.getLabelIds()),"标签id不能为空");
            SubjectInfoBO subjectInfoBO= SubjectInfoDTOConverter.INSTANCE.convertDtoToInfoBO(subjectInfoDTO);
            List<SubjectAnswerBO> subjectAnswerBOS= SubjectAnswerDTOConverter.
                    INSTANCE.convertDTOToBOList(subjectInfoDTO.getOptionList());
            subjectInfoBO.setOptionList(subjectAnswerBOS);
          Boolean res =  subjectInfoDomainSerivice.add(subjectInfoBO);
            return Result.success(res);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增标签失败");
        }
    }
}
