package com.qihang.subject.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.domain.service.SubjectInfoDomainSerivice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description: 题目信息
 * @Author:bread
 * @Date: 2024-08-26 17:11
 */
@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainSerivice {


    @Override
    public Boolean add(SubjectInfoBO subjectInfoBO) {
        if(log.isInfoEnabled()){
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        return null;
    }
}
