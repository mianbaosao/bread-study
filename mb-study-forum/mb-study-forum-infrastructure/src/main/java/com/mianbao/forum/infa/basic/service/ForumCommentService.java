package com.mianbao.forum.infa.basic.service;

import com.mianbao.forum.infa.basic.entity.ForumComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ForumComment)表服务接口
 *
 * @author makejava
 * @since 2024-10-17 18:52:21
 */
public interface ForumCommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ForumComment queryById(Integer id);

    /**
     * 分页查询
     *
     * @param forumComment 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    Page<ForumComment> queryByPage(ForumComment forumComment, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param forumComment 实例对象
     * @return 实例对象
     */
    ForumComment insert(ForumComment forumComment);

    /**
     * 修改数据
     *
     * @param forumComment 实例对象
     * @return 实例对象
     */
    ForumComment update(ForumComment forumComment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
