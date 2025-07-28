package com.lingosphinx.lesson.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class CourseSearch extends Search<Course> {
}
