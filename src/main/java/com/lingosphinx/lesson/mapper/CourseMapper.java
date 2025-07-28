package com.lingosphinx.lesson.mapper;


import com.lingosphinx.lesson.domain.Course;
import com.lingosphinx.lesson.domain.Unit;
import com.lingosphinx.lesson.dto.CourseDto;
import com.lingosphinx.lesson.dto.UnitDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CourseMapper {
    CourseDto toDto(Course course);
    Course toEntity(CourseDto courseDto);

    @Mapping(target = "course", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    UnitDto toDto(Unit unit);
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    Unit toEntity(UnitDto unitDto);

    @Mapping(target = "units", ignore = true)
    void updateEntityFromDto(CourseDto courseDto, @MappingTarget Course course);

    @Mapping(target = "course", ignore = true)
    @Mapping(target = "lessons", ignore = true)
    void updateEntityFromDto(UnitDto unitDto, @MappingTarget Unit unit);
}
