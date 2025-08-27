package com.lingosphinx.lesson.dto;

import com.lingosphinx.gamification.dto.GoalDto;
import com.lingosphinx.lesson.dto.CarouselItem;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Setter
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
public abstract class Carousel<T> {
    protected List<CarouselItem<T>> items;
}