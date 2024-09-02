package com.qihang.subject.domain.convert;

import com.qihang.subject.domain.entity.SubjectAnswerBO;
import com.qihang.subject.infrastructure.basic.entity.SubjectRadio;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-02T15:12:04+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
public class RadioSubjectConverterImpl implements RadioSubjectConverter {

    @Override
    public SubjectRadio converBoToRadio(SubjectAnswerBO subjectAnswerBO) {
        if ( subjectAnswerBO == null ) {
            return null;
        }

        SubjectRadio subjectRadio = new SubjectRadio();

        subjectRadio.setOptionType( subjectAnswerBO.getOptionType() );
        subjectRadio.setOptionContent( subjectAnswerBO.getOptionContent() );
        subjectRadio.setIsCorrect( subjectAnswerBO.getIsCorrect() );

        return subjectRadio;
    }
}
