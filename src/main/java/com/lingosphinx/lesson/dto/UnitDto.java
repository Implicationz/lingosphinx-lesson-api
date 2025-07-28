package com.lingosphinx.lesson.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnitDto extends ContentItemDto {

    private Long id;
    private CourseDto course;
    private int position;
    private List<LessonDto> lessons;
    
}