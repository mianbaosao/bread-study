package com.mianbao.forum.infa.basic.service.impl;

import com.mianbao.forum.infa.basic.dao.ForumBlogdataDao;
import com.mianbao.forum.infa.basic.entity.ForumBlogdata;
import com.mianbao.forum.infa.basic.service.ForumBlogdataService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ForumBlogdata)表服务实现类
 *
 * @author makejava
 * @since 2024-10-17 18:52:20
 */
@Service("forumBlogdataService")
public class ForumBlogdataServiceImpl implements ForumBlogdataService {
    @Resource
    private ForumBlogdataDao forumBlogdataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param blogid 主键
     * @return 实例对象
     */
    @Override
    public ForumBlogdata queryById(Integer blogid) {
        return this.forumBlogdataDao.queryById(blogid);
    }

    /**
     * 分页查询
     *
     * @param forumBlogdata 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @Override
    public Page<ForumBlogdata> queryByPage(ForumBlogdata forumBlogdata, PageRequest pageRequest) {
        long total = this.forumBlogdataDao.count(forumBlogdata);
        return new PageImpl<>(this.forumBlogdataDao.queryAllByLimit(forumBlogdata, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param forumBlogdata 实例对象
     * @return 实例对象
     */
    @Override
    public ForumBlogdata insert(ForumBlogdata forumBlogdata) {
        this.forumBlogdataDao.insert(forumBlogdata);
        return forumBlogdata;
    }

    /**
     * 修改数据
     *
     * @param forumBlogdata 实例对象
     * @return 实例对象
     */
    @Override
    public ForumBlogdata update(ForumBlogdata forumBlogdata) {
        this.forumBlogdataDao.update(forumBlogdata);
        return this.queryById(forumBlogdata.getBlogid());
    }

    /**
     * 通过主键删除数据
     *
     * @param blogid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer blogid) {
        return this.forumBlogdataDao.deleteById(blogid) > 0;
    }
}
