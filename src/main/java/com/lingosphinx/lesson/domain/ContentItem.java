package com.lingosphinx.lesson.domain;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ContentItem {

    @Enumerated(EnumType.STRING)
    private LessonType type;

    @Enumerated(EnumType.STRING)
    private LessonDifficulty difficulty;

    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    private String ownerId;

    private int estimatedDuration;

    private String image;
}