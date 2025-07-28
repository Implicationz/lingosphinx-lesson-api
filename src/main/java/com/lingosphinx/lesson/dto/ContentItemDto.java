package com.lingosphinx.lesson.dto;

import com.lingosphinx.lesson.domain.LanguageCode;
import com.lingosphinx.lesson.domain.LessonDifficulty;
import com.lingosphinx.lesson.domain.Visibility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ContentItemDto {

    private String title;
    private String titleTranslation;
    private String titleTranscription;

    private SubjectDto subject;
    private TopicDto topic;
    private LanguageCode language;
    private LessonTypeDto type;
    private LessonDifficulty difficulty;
    private Visibility visibility;
    private String ownerId;
    private int estimatedDuration;
    private String image;
}