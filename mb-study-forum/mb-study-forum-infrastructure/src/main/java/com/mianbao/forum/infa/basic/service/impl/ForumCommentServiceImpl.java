package com.mianbao.forum.infa.basic.service.impl;

import com.mianbao.forum.infa.basic.entity.ForumComment;
import com.mianbao.forum.infa.basic.service.ForumCommentService;
import com.mianbao.forum.infa.basic.dao.ForumCommentDao;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ForumComment)表服务实现类
 *
 * @author makejava
 * @since 2024-10-17 18:52:22
 */
@Service("forumCommentService")
public class ForumCommentServiceImpl implements ForumCommentService {
    @Resource
    private ForumCommentDao forumCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ForumComment queryById(Integer id) {
        return this.forumCommentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param forumComment 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @Override
    public Page<ForumComment> queryByPage(ForumComment forumComment, PageRequest pageRequest) {
        long total = this.forumCommentDao.count(forumComment);
        return new PageImpl<>(this.forumCommentDao.queryAllByLimit(forumComment, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param forumComment 实例对象
     * @return 实例对象
     */
    @Override
    public ForumComment insert(ForumComment forumComment) {
        this.forumCommentDao.insert(forumComment);
        return forumComment;
    }

    /**
     * 修改数据
     *
     * @param forumComment 实例对象
     * @return 实例对象
     */
    @Override
    public ForumComment update(ForumComment forumComment) {
        this.forumCommentDao.update(forumComment);
        return this.queryById(forumComment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.forumCommentDao.deleteById(id) > 0;
    }
}
