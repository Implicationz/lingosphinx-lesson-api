package com.lingosphinx.lesson.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Builder
@Setter
@Getter
public class LessonSearch extends Search<Lesson> {
}
