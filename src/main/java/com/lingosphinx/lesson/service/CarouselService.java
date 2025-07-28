package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.domain.LanguageCode;
import com.lingosphinx.lesson.dto.CourseCarousel;
import com.lingosphinx.lesson.dto.LessonCarousel;
import com.lingosphinx.lesson.dto.UnitCarousel;

public interface CarouselService {
    LessonCarousel lessonCarousel(LanguageCode language);
    UnitCarousel unitCarousel(LanguageCode language);
    CourseCarousel courseCarousel(LanguageCode language);
}
