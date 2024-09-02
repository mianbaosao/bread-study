package com.qihang.subject.domain.convert;

import com.qihang.subject.domain.entity.SubjectAnswerBO;
import com.qihang.subject.domain.entity.SubjectInfoBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-02T15:12:04+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
public class SubjectInfoConverterImpl implements SubjectInfoConverter {

    @Override
    public SubjectInfo converBoToInfo(SubjectAnswerBO subjectAnswerBO) {
        if ( subjectAnswerBO == null ) {
            return null;
        }

        SubjectInfo subjectInfo = new SubjectInfo();

        return subjectInfo;
    }

    @Override
    public List<SubjectInfoBO> convertBoToLInfo(List<SubjectInfo> infoList) {
        if ( infoList == null ) {
            return null;
        }

        List<SubjectInfoBO> list = new ArrayList<SubjectInfoBO>( infoList.size() );
        for ( SubjectInfo subjectInfo : infoList ) {
            list.add( subjectInfoToSubjectInfoBO( subjectInfo ) );
        }

        return list;
    }

    protected SubjectInfoBO subjectInfoToSubjectInfoBO(SubjectInfo subjectInfo) {
        if ( subjectInfo == null ) {
            return null;
        }

        SubjectInfoBO subjectInfoBO = new SubjectInfoBO();

        subjectInfoBO.setId( subjectInfo.getId() );
        subjectInfoBO.setSubjectName( subjectInfo.getSubjectName() );
        subjectInfoBO.setSubjectDifficult( subjectInfo.getSubjectDifficult() );
        subjectInfoBO.setSettleName( subjectInfo.getSettleName() );
        subjectInfoBO.setSubjectType( subjectInfo.getSubjectType() );
        subjectInfoBO.setSubjectScore( subjectInfo.getSubjectScore() );
        subjectInfoBO.setSubjectParse( subjectInfo.getSubjectParse() );

        return subjectInfoBO;
    }
}
