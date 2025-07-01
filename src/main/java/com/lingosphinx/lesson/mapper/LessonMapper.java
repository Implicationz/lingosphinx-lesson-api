package com.lingosphinx.lesson.mapper;

import com.lingosphinx.lesson.domain.Lesson;
import com.lingosphinx.lesson.dto.LessonDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LessonMapper {
    LessonDto toDto(Lesson lesson);
    Lesson toEntity(LessonDto lessonDto);

}
