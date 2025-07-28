package com.lingosphinx.lesson.mapper;

import com.lingosphinx.lesson.domain.Course;
import com.lingosphinx.lesson.domain.Lesson;
import com.lingosphinx.lesson.domain.Material;
import com.lingosphinx.lesson.domain.Unit;
import com.lingosphinx.lesson.dto.CourseDto;
import com.lingosphinx.lesson.dto.LessonDto;
import com.lingosphinx.lesson.dto.MaterialDto;
import com.lingosphinx.lesson.dto.UnitDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LessonMapper {
    LessonDto toDto(Lesson lesson);
    Lesson toEntity(LessonDto lessonDto);

    @Mapping(target = "units", ignore = true)
    CourseDto toDto(Course course);
    @Mapping(target = "units", ignore = true)
    Course toEntity(CourseDto courseDto);

    @Mapping(target = "lessons", ignore = true)
    UnitDto toDto(Unit unit);
    @Mapping(target = "lessons", ignore = true)
    Unit toEntity(UnitDto unitDto);

    @Mapping(target = "lesson", ignore = true)
    MaterialDto toDto(Material material);
    @Mapping(target = "lesson", ignore = true)
    Material toEntity(MaterialDto materialDto);

    @Mapping(target = "materials", ignore = true)
    void updateEntityFromDto(LessonDto lessonDto, @MappingTarget Lesson lesson);

    @Mapping(target = "lesson", ignore = true)
    void updateEntityFromDto(MaterialDto materialDto, @MappingTarget Material material);
}
