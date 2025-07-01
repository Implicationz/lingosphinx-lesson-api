package com.lingosphinx.lesson.dto;

import com.lingosphinx.lesson.domain.LessonDifficulty;
import com.lingosphinx.lesson.domain.LessonType;
import com.lingosphinx.lesson.domain.Visibility;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ContentItemDto {
    private LessonType type;
    private LessonDifficulty difficulty;
    private Visibility visibility;
    private String ownerId;
    private int estimatedDuration;
    private String image;
}