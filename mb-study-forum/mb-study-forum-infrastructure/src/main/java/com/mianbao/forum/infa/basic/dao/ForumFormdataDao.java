package com.mianbao.forum.infa.basic.dao;

import com.mianbao.forum.infa.basic.entity.ForumFormdata;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (ForumFormdata)表数据库访问层
 *
 * @author makejava
 * @since 2024-10-17 18:52:22
 */
public interface ForumFormdataDao {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryid 主键
     * @return 实例对象
     */
    ForumFormdata queryById(Integer categoryid);

    /**
     * 查询指定行数据
     *
     * @param forumFormdata 查询条件
     * @param pageable      分页对象
     * @return 对象列表
     */
    List<ForumFormdata> queryAllByLimit(ForumFormdata forumFormdata, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param forumFormdata 查询条件
     * @return 总行数
     */
    long count(ForumFormdata forumFormdata);

    /**
     * 新增数据
     *
     * @param forumFormdata 实例对象
     * @return 影响行数
     */
    int insert(ForumFormdata forumFormdata);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ForumFormdata> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ForumFormdata> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ForumFormdata> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ForumFormdata> entities);

    /**
     * 修改数据
     *
     * @param forumFormdata 实例对象
     * @return 影响行数
     */
    int update(ForumFormdata forumFormdata);

    /**
     * 通过主键删除数据
     *
     * @param categoryid 主键
     * @return 影响行数
     */
    int deleteById(Integer categoryid);

}

