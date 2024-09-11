package com.mianbao.subject.domain.entity;


import com.qihang.subject.common.entity.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 题目信息表(SubjectInfo)实体类
 *
 * @author makejava
 * @since 2024-08-26 15:54:40
 */
@Data
public class SubjectInfoBO extends PageInfo implements Serializable {

    /**
     * 主键
     */
    private Long id;
    /**
     * 题目名称
     */
    private String subjectName;
    /**
     * 题目难度
     */
    private Integer subjectDifficult;
    /**
     * 出题人名
     */
    private String settleName;
    /**
     * 题目类型 1单选 2多选 3判断 4简答
     */
    private Integer subjectType;
    /**
     * 题目分数
     */
    private Integer subjectScore;
    /**
     * 题目解析
     */
    private String subjectParse;
    /**
     * 题目答案
     */
    private String subjectAnswer;
    /**
     * 分类id
     */
    private List<Long> categoryIds;
    /**
     * 标签id
     */
    private List<Long>labelIds;
    /**
     * 标签name
     */
    private List<String> labelName;
    /**
     * 题目答案列表
     */
    private List<SubjectAnswerBO>optionList;

    private Long categoryId;

    private Long labelId;


}

