package com.qihang.subject.infrastructure.basic.service;

import com.qihang.subject.infrastructure.basic.entity.SubjectJudge;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 判断题(SubjectJudge)表服务接口
 *
 * @author makejava
 * @since 2024-08-26 15:52:05
 */
public interface SubjectJudgeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectJudge queryById(Long id);

    /**
     * 新增数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    SubjectJudge insert(SubjectJudge subjectJudge);

    /**
     * 修改数据
     *
     * @param subjectJudge 实例对象
     * @return 实例对象
     */
    SubjectJudge update(SubjectJudge subjectJudge);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
