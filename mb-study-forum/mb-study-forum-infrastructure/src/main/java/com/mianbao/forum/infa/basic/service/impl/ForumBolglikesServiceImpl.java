package com.mianbao.forum.infa.basic.service.impl;

import com.mianbao.forum.infa.basic.dao.ForumBolglikesDao;
import com.mianbao.forum.infa.basic.entity.ForumBolglikes;
import com.mianbao.forum.infa.basic.service.ForumBolglikesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ForumBolglikes)表服务实现类
 *
 * @author makejava
 * @since 2024-10-17 18:52:21
 */
@Service("forumBolglikesService")
public class ForumBolglikesServiceImpl implements ForumBolglikesService {
    @Resource
    private ForumBolglikesDao forumBolglikesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param likeId 主键
     * @return 实例对象
     */
    @Override
    public ForumBolglikes queryById(Integer likeId) {
        return this.forumBolglikesDao.queryById(likeId);
    }

    /**
     * 分页查询
     *
     * @param forumBolglikes 筛选条件
     * @param pageRequest    分页对象
     * @return 查询结果
     */
    @Override
    public Page<ForumBolglikes> queryByPage(ForumBolglikes forumBolglikes, PageRequest pageRequest) {
        long total = this.forumBolglikesDao.count(forumBolglikes);
        return new PageImpl<>(this.forumBolglikesDao.queryAllByLimit(forumBolglikes, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param forumBolglikes 实例对象
     * @return 实例对象
     */
    @Override
    public ForumBolglikes insert(ForumBolglikes forumBolglikes) {
        this.forumBolglikesDao.insert(forumBolglikes);
        return forumBolglikes;
    }

    /**
     * 修改数据
     *
     * @param forumBolglikes 实例对象
     * @return 实例对象
     */
    @Override
    public ForumBolglikes update(ForumBolglikes forumBolglikes) {
        this.forumBolglikesDao.update(forumBolglikes);
        return this.queryById(forumBolglikes.getLikeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param likeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer likeId) {
        return this.forumBolglikesDao.deleteById(likeId) > 0;
    }
}
