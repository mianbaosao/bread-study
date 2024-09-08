package com.qihang.subject.domain.convert;

import com.qihang.subject.domain.entity.SubjectLabelBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectLabel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-08T16:28:02+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
public class SubjectLabelConverterImpl implements SubjectLabelConverter {

    @Override
    public SubjectLabel converBoToLabel(SubjectLabelBO subjectLabelBO) {
        if ( subjectLabelBO == null ) {
            return null;
        }

        SubjectLabel subjectLabel = new SubjectLabel();

        subjectLabel.setId( subjectLabelBO.getId() );
        subjectLabel.setLabelName( subjectLabelBO.getLabelName() );
        subjectLabel.setSortNum( subjectLabelBO.getSortNum() );
        if ( subjectLabelBO.getCategoryId() != null ) {
            subjectLabel.setCategoryId( String.valueOf( subjectLabelBO.getCategoryId() ) );
        }

        return subjectLabel;
    }

    @Override
    public List<SubjectLabelBO> convertBoToLLabel(List<SubjectLabel> LabelList) {
        if ( LabelList == null ) {
            return null;
        }

        List<SubjectLabelBO> list = new ArrayList<SubjectLabelBO>( LabelList.size() );
        for ( SubjectLabel subjectLabel : LabelList ) {
            list.add( subjectLabelToSubjectLabelBO( subjectLabel ) );
        }

        return list;
    }

    protected SubjectLabelBO subjectLabelToSubjectLabelBO(SubjectLabel subjectLabel) {
        if ( subjectLabel == null ) {
            return null;
        }

        SubjectLabelBO subjectLabelBO = new SubjectLabelBO();

        subjectLabelBO.setId( subjectLabel.getId() );
        subjectLabelBO.setLabelName( subjectLabel.getLabelName() );
        subjectLabelBO.setSortNum( subjectLabel.getSortNum() );
        if ( subjectLabel.getCategoryId() != null ) {
            subjectLabelBO.setCategoryId( Long.parseLong( subjectLabel.getCategoryId() ) );
        }

        return subjectLabelBO;
    }
}
