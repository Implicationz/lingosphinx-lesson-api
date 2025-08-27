package com.lingosphinx.lesson.dto;

import com.lingosphinx.gamification.dto.GoalDto;
import com.lingosphinx.lesson.domain.Lesson;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class LessonCarousel extends Carousel<LessonDto> {

    public static LessonCarousel zipped(List<LessonDto> contents, List<GoalDto> goals)
    {
        return LessonCarousel.builder().items(CarouselItem.zipped(contents, goals)).build();
    }
}
