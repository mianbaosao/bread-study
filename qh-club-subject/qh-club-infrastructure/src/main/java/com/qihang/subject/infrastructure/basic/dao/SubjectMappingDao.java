package com.qihang.subject.infrastructure.basic.dao;

import com.qihang.subject.infrastructure.basic.entity.SubjectMapping;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 题目分类关系表(SubjectMapping)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-23 15:29:56
 */
public interface SubjectMappingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectMapping queryById(Long id);


    /**
     * 统计总行数
     *
     * @param subjectMapping 查询条件
     * @return 总行数
     */
    long count(SubjectMapping subjectMapping);

    /**
     * 新增数据
     *
     * @param subjectMapping 实例对象
     * @return 影响行数
     */
    int insert(SubjectMapping subjectMapping);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SubjectMapping> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SubjectMapping> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SubjectMapping> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SubjectMapping> entities);

    /**
     * 修改数据
     *
     * @param subjectMapping 实例对象
     * @return 影响行数
     */
    int update(SubjectMapping subjectMapping);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 根据分类id查看标签id
     * @param subjectMapping
     * @return
     */
    List<SubjectMapping> queryLabelIdListById(SubjectMapping subjectMapping);
}

