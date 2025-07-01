package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.dto.LessonDto;

import java.util.List;

public interface LessonService {
    LessonDto create(LessonDto lesson);
    LessonDto readById(Long id);
    List<LessonDto> readAll();
    LessonDto update(Long id, LessonDto lesson);
    void delete(Long id);
}
