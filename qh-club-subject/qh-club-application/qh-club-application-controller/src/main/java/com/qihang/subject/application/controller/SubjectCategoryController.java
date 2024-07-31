package com.qihang.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.qihang.subject.application.convert.SubjectCategoryDTOConverter;
import com.qihang.subject.application.dto.SubjectCategoryDTO;
import com.qihang.subject.common.entity.Result;
import com.qihang.subject.domain.entity.SubjectCategoryBO;
import com.qihang.subject.domain.service.SubjectCategoryDomainService;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 题目分类控制层
 * @Author:bread
 * @Date: 2024-07-30 9:43
 */

@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {
    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 新增分类
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try {
            if (log.isInfoEnabled()) {
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getCategoryType(), "分类类型不能为空");
            // StringUtils.isBlank来检查字符串是否为空白，StringUtils.isBlank 会返回 true 如果字符串为 null
            Preconditions.checkArgument(!StringUtils.isBlank(subjectCategoryDTO.getCategoryName()), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParentId(), "分类父级id不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToCategoryBO(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.success(true);
        } catch (Exception e) {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(), e);
            return Result.fail("新增分类失败");
        }
    }

    /**
     * 查询分类
     * @return
     */
    @GetMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(){

        try {
            List<SubjectCategoryBO> categoryBOS = subjectCategoryDomainService.queryPrimaryCategory();
            List<SubjectCategoryDTO> subjectCategoryDTOS=SubjectCategoryDTOConverter.INSTANCE
                    .convertBoToCategoryDTOList(categoryBOS);
            return Result.success(subjectCategoryDTOS);
        }catch (Exception e){
            log.error("SubjectCategoryController.query.error:{}", e.getMessage(), e);
            return Result.fail("查询分类失败");
        }

    }

}
