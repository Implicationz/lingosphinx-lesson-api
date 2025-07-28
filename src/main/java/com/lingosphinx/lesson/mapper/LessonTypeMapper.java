package com.lingosphinx.lesson.mapper;

import com.lingosphinx.lesson.domain.LessonType;
import com.lingosphinx.lesson.dto.LessonTypeDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LessonTypeMapper {
    LessonTypeDto toDto(LessonType lessonType);
    LessonType toEntity(LessonTypeDto lessonTypeDto);

}
