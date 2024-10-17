package com.mianbao.forum.infa.basic.service;

import com.mianbao.forum.infa.basic.entity.ForumBolglikes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ForumBolglikes)表服务接口
 *
 * @author makejava
 * @since 2024-10-17 18:52:21
 */
public interface ForumBolglikesService {

    /**
     * 通过ID查询单条数据
     *
     * @param likeId 主键
     * @return 实例对象
     */
    ForumBolglikes queryById(Integer likeId);

    /**
     * 分页查询
     *
     * @param forumBolglikes 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    Page<ForumBolglikes> queryByPage(ForumBolglikes forumBolglikes, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param forumBolglikes 实例对象
     * @return 实例对象
     */
    ForumBolglikes insert(ForumBolglikes forumBolglikes);

    /**
     * 修改数据
     *
     * @param forumBolglikes 实例对象
     * @return 实例对象
     */
    ForumBolglikes update(ForumBolglikes forumBolglikes);

    /**
     * 通过主键删除数据
     *
     * @param likeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer likeId);

}
