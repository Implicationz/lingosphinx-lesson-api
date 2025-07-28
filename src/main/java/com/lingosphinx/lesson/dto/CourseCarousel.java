package com.lingosphinx.lesson.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class CourseCarousel extends Carousel<CourseDto> {
}
