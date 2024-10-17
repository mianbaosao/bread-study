package com.mianbao.forum.infa.basic.service;

import com.mianbao.forum.infa.basic.entity.ForumBlogdata;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ForumBlogdata)表服务接口
 *
 * @author makejava
 * @since 2024-10-17 18:52:20
 */
public interface ForumBlogdataService {

    /**
     * 通过ID查询单条数据
     *
     * @param blogid 主键
     * @return 实例对象
     */
    ForumBlogdata queryById(Integer blogid);

    /**
     * 分页查询
     *
     * @param forumBlogdata 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    Page<ForumBlogdata> queryByPage(ForumBlogdata forumBlogdata, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param forumBlogdata 实例对象
     * @return 实例对象
     */
    ForumBlogdata insert(ForumBlogdata forumBlogdata);

    /**
     * 修改数据
     *
     * @param forumBlogdata 实例对象
     * @return 实例对象
     */
    ForumBlogdata update(ForumBlogdata forumBlogdata);

    /**
     * 通过主键删除数据
     *
     * @param blogid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer blogid);

}
