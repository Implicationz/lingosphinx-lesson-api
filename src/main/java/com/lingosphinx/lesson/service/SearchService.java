package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.domain.CourseSearch;
import com.lingosphinx.lesson.domain.LessonSearch;
import com.lingosphinx.lesson.domain.UnitSearch;

public interface SearchService {
    LessonSearch search(LessonSearch search);
    UnitSearch search(UnitSearch search);
    CourseSearch search(CourseSearch search);
}
