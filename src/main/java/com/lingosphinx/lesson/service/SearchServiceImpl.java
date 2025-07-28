package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.domain.CourseSearch;
import com.lingosphinx.lesson.domain.LessonSearch;
import com.lingosphinx.lesson.domain.UnitSearch;
import com.lingosphinx.lesson.mapper.LessonMapper;
import com.lingosphinx.lesson.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SearchServiceImpl implements SearchService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public LessonSearch search(LessonSearch search) {
        return LessonSearch.builder().build();
    }

    @Override
    public UnitSearch search(UnitSearch search) {
        return UnitSearch.builder().build();
    }

    @Override
    public CourseSearch search(CourseSearch search) {
        return CourseSearch.builder().build();
    }
}