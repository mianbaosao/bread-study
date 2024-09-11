package com.mianbao.subject.infrastructure.basic.service;

import com.mianbao.subject.infrastructure.basic.entity.SubjectMapping;

import java.util.List;

/**
 * 题目分类关系表(SubjectMapping)表服务接口
 *
 * @author makejava
 * @since 2024-08-23 15:29:56
 */
public interface SubjectMappingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMapping queryById(Long id);



    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    SubjectMapping insert(SubjectMapping subjectMapping);

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 实例对象
     */
    SubjectMapping update(SubjectMapping subjectMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 根据分类id查询标签id
     * @param subjectMapping
     * @return
     */
    List<SubjectMapping> queryLabelIdListById(SubjectMapping subjectMapping);

    /**
     * 批量插入
     * @param subjectMappingList
     */
    void batchInsert(List<SubjectMapping> subjectMappingList);

    /**
     * 查询标签id
     * @param subjectMapping
     * @return
     */
    List<SubjectMapping> queryLabelId(SubjectMapping subjectMapping);
}
