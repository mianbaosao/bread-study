package com.mianbao.forum.infa.basic.dao;

import com.mianbao.forum.infa.basic.entity.ForumBolglikes;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (ForumBolglikes)表数据库访问层
 *
 * @author makejava
 * @since 2024-10-17 18:52:21
 */
public interface ForumBolglikesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param likeId 主键
     * @return 实例对象
     */
    ForumBolglikes queryById(Integer likeId);

    /**
     * 查询指定行数据
     *
     * @param forumBolglikes 查询条件
     * @param pageable       分页对象
     * @return 对象列表
     */
    List<ForumBolglikes> queryAllByLimit(ForumBolglikes forumBolglikes, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param forumBolglikes 查询条件
     * @return 总行数
     */
    long count(ForumBolglikes forumBolglikes);

    /**
     * 新增数据
     *
     * @param forumBolglikes 实例对象
     * @return 影响行数
     */
    int insert(ForumBolglikes forumBolglikes);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ForumBolglikes> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ForumBolglikes> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ForumBolglikes> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ForumBolglikes> entities);

    /**
     * 修改数据
     *
     * @param forumBolglikes 实例对象
     * @return 影响行数
     */
    int update(ForumBolglikes forumBolglikes);

    /**
     * 通过主键删除数据
     *
     * @param likeId 主键
     * @return 影响行数
     */
    int deleteById(Integer likeId);

}

