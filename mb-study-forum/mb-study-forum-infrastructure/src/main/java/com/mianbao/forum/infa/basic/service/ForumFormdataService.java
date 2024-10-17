package com.mianbao.forum.infa.basic.service;

import com.mianbao.forum.infa.basic.entity.ForumFormdata;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ForumFormdata)表服务接口
 *
 * @author makejava
 * @since 2024-10-17 18:52:22
 */
public interface ForumFormdataService {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryid 主键
     * @return 实例对象
     */
    ForumFormdata queryById(Integer categoryid);

    /**
     * 分页查询
     *
     * @param forumFormdata 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    Page<ForumFormdata> queryByPage(ForumFormdata forumFormdata, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param forumFormdata 实例对象
     * @return 实例对象
     */
    ForumFormdata insert(ForumFormdata forumFormdata);

    /**
     * 修改数据
     *
     * @param forumFormdata 实例对象
     * @return 实例对象
     */
    ForumFormdata update(ForumFormdata forumFormdata);

    /**
     * 通过主键删除数据
     *
     * @param categoryid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer categoryid);

}
