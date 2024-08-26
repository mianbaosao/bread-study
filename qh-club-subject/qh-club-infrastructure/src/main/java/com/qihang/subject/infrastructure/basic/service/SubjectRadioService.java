package com.qihang.subject.infrastructure.basic.service;

import com.qihang.subject.infrastructure.basic.entity.SubjectRadio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 单选题信息表(SubjectRadio)表服务接口
 *
 * @author makejava
 * @since 2024-08-26 15:49:07
 */
public interface SubjectRadioService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectRadio queryById(Long id);


    /**
     * 新增数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    SubjectRadio insert(SubjectRadio subjectRadio);

    /**
     * 修改数据
     *
     * @param subjectRadio 实例对象
     * @return 实例对象
     */
    SubjectRadio update(SubjectRadio subjectRadio);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
