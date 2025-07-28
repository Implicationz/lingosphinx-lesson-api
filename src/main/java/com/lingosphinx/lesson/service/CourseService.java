package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto create(CourseDto course);
    CourseDto readById(Long id);
    List<CourseDto> readAll();
    CourseDto update(Long id, CourseDto course);
    void delete(Long id);
}
