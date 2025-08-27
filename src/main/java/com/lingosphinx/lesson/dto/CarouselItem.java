package com.lingosphinx.lesson.dto;

import com.lingosphinx.gamification.dto.GoalDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarouselItem<T> {
    private T content;
    private GoalDto goal;


    public static <T> List<CarouselItem<T>> zipped(List<T> contents, List<GoalDto> goals)
    {
        var items = new ArrayList<CarouselItem<T>>();
        for (int i = 0; i < Math.min(contents.size(), goals.size()); i++) {
            items.add(new CarouselItem<>(contents.get(i), goals.get(i)));
        }
        return items;
    }
}
