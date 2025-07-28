package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.dto.LessonTypeDto;

import java.util.List;

public interface LessonTypeService {
    LessonTypeDto create(LessonTypeDto lessonType);
    LessonTypeDto readById(Long id);
    List<LessonTypeDto> readAll();
    LessonTypeDto update(Long id, LessonTypeDto lessonType);
    void delete(Long id);
}
