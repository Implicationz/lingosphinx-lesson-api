package com.lingosphinx.lesson.mapper;

import com.lingosphinx.lesson.domain.Subject;
import com.lingosphinx.lesson.dto.SubjectDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface SubjectMapper {
    SubjectDto toDto(Subject subject);
    Subject toEntity(SubjectDto subjectDto);

}
