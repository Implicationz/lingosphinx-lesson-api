package com.lingosphinx.lesson.dto;

import com.lingosphinx.gamification.dto.GoalDto;
import com.lingosphinx.lesson.domain.Course;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class CourseCarousel extends Carousel<CourseDto> {
    public static CourseCarousel zipped(List<CourseDto> contents, List<GoalDto> goals)
    {
        return CourseCarousel.builder().items(CarouselItem.zipped(contents, goals)).build();
    }
}
