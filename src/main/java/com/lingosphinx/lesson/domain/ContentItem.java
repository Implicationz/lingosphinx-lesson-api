package com.lingosphinx.lesson.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ContentItem {

    private String title;
    private String titleTranslation;
    private String titleTranscription;

    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Topic topic;

    @Column(nullable = false)
    private LanguageCode language;

    @ManyToOne
    @JoinColumn(nullable = false)
    private LessonType type;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private LessonDifficulty difficulty = LessonDifficulty.A1;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Visibility visibility = Visibility.PRIVATE;

    private String ownerId;

    private int estimatedDuration;

    private String image;
}