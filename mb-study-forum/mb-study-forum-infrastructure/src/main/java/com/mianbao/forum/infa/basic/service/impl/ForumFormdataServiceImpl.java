package com.mianbao.forum.infa.basic.service.impl;

import com.mianbao.forum.infa.basic.dao.ForumFormdataDao;
import com.mianbao.forum.infa.basic.entity.ForumFormdata;
import com.mianbao.forum.infa.basic.service.ForumFormdataService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ForumFormdata)表服务实现类
 *
 * @author makejava
 * @since 2024-10-17 18:52:22
 */
@Service("forumFormdataService")
public class ForumFormdataServiceImpl implements ForumFormdataService {
    @Resource
    private ForumFormdataDao forumFormdataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param categoryid 主键
     * @return 实例对象
     */
    @Override
    public ForumFormdata queryById(Integer categoryid) {
        return this.forumFormdataDao.queryById(categoryid);
    }

    /**
     * 分页查询
     *
     * @param forumFormdata 筛选条件
     * @param pageRequest   分页对象
     * @return 查询结果
     */
    @Override
    public Page<ForumFormdata> queryByPage(ForumFormdata forumFormdata, PageRequest pageRequest) {
        long total = this.forumFormdataDao.count(forumFormdata);
        return new PageImpl<>(this.forumFormdataDao.queryAllByLimit(forumFormdata, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param forumFormdata 实例对象
     * @return 实例对象
     */
    @Override
    public ForumFormdata insert(ForumFormdata forumFormdata) {
        this.forumFormdataDao.insert(forumFormdata);
        return forumFormdata;
    }

    /**
     * 修改数据
     *
     * @param forumFormdata 实例对象
     * @return 实例对象
     */
    @Override
    public ForumFormdata update(ForumFormdata forumFormdata) {
        this.forumFormdataDao.update(forumFormdata);
        return this.queryById(forumFormdata.getCategoryid());
    }

    /**
     * 通过主键删除数据
     *
     * @param categoryid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer categoryid) {
        return this.forumFormdataDao.deleteById(categoryid) > 0;
    }
}
