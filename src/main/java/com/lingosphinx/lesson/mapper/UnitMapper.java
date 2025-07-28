package com.lingosphinx.lesson.mapper;

import com.lingosphinx.lesson.domain.Course;
import com.lingosphinx.lesson.domain.Lesson;
import com.lingosphinx.lesson.domain.Unit;
import com.lingosphinx.lesson.dto.CourseDto;
import com.lingosphinx.lesson.dto.LessonDto;
import com.lingosphinx.lesson.dto.UnitDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface UnitMapper {
    UnitDto toDto(Unit unit);
    Unit toEntity(UnitDto unitDto);

    @Mapping(target = "units", ignore = true)
    CourseDto toDto(Course course);
    @Mapping(target = "units", ignore = true)
    Course toEntity(CourseDto courseDto);

    @Mapping(target = "unit", ignore = true)
    @Mapping(target = "materials", ignore = true)
    LessonDto toDto(Lesson lesson);
    @Mapping(target = "unit", ignore = true)
    @Mapping(target = "materials", ignore = true)
    Lesson toEntity(LessonDto lessonDto);

    @Mapping(target = "lessons", ignore = true)
    void updateEntityFromDto(UnitDto unitDto, @MappingTarget Unit unit);

    @Mapping(target = "unit", ignore = true)
    @Mapping(target = "materials", ignore = true)
    void updateEntityFromDto(LessonDto lessonDto, @MappingTarget Lesson lesson);

}
