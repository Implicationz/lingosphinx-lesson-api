package com.lingosphinx.lesson.dto;

import com.lingosphinx.gamification.dto.GoalDto;
import com.lingosphinx.lesson.domain.Unit;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@SuperBuilder
public class UnitCarousel extends Carousel<UnitDto> {
    public static UnitCarousel zipped(List<UnitDto> contents, List<GoalDto> goals)
    {
        return UnitCarousel.builder().items(CarouselItem.zipped(contents, goals)).build();
    }
}
