package com.lingosphinx.lesson.dto;

import com.lingosphinx.lesson.domain.MaterialType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialDto {

    private Long id;
    @Builder.Default
    private MaterialType type = MaterialType.TEXT;
    private LessonDto lesson;
    
    private String quiz;
    
    private String summary;

    @Builder.Default
    private int questionCount = 0;
    @Builder.Default
    private int wordCount = 0;
    
    private String artifact;

    private String goal;
}