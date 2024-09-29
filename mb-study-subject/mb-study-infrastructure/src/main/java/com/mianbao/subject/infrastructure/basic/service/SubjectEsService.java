package com.mianbao.subject.infrastructure.basic.service;


import com.mianbao.subject.common.entity.PageResult;
import com.mianbao.subject.infrastructure.basic.entity.SubjectInfoEs;

public interface SubjectEsService {

    boolean insert(SubjectInfoEs subjectInfoEs);

    PageResult<SubjectInfoEs> querySubjectList(SubjectInfoEs subjectInfoEs);

}
