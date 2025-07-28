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
public class LessonDto extends ContentItemDto {

    private Long id;
    private UnitDto unit;
    private int position;
    private List<MaterialDto> materials;

}