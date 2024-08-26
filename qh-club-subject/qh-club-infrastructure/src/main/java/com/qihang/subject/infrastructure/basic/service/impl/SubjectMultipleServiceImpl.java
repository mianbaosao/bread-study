package com.qihang.subject.infrastructure.basic.service.impl;

import com.qihang.subject.infrastructure.basic.entity.SubjectMultiple;
import com.qihang.subject.infrastructure.basic.dao.SubjectMultipleDao;
import com.qihang.subject.infrastructure.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 多选题信息表(SubjectMultiple)表服务实现类
 *
 * @author makejava
 * @since 2024-08-26 15:53:36
 */
@Service("subjectMultipleService")
public class SubjectMultipleServiceImpl implements SubjectMultipleService {
    @Resource
    private SubjectMultipleDao subjectMultipleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectMultiple queryById(Long id) {
        return this.subjectMultipleDao.queryById(id);
    }

   /* *//**
     * 分页查询
     *
     * @param subjectMultiple 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     *//*
    @Override
    public Page<SubjectMultiple> queryByPage(SubjectMultiple subjectMultiple, PageRequest pageRequest) {
        long total = this.subjectMultipleDao.count(subjectMultiple);
        return new PageImpl<>(this.subjectMultipleDao.queryAllByLimit(subjectMultiple, pageRequest), pageRequest, total);
    }*/

    /**
     * 新增数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectMultiple insert(SubjectMultiple subjectMultiple) {
        this.subjectMultipleDao.insert(subjectMultiple);
        return subjectMultiple;
    }

    /**
     * 修改数据
     *
     * @param subjectMultiple 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectMultiple update(SubjectMultiple subjectMultiple) {
        this.subjectMultipleDao.update(subjectMultiple);
        return this.queryById(subjectMultiple.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectMultipleDao.deleteById(id) > 0;
    }
}
