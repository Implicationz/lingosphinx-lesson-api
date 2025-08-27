package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.client.GamificationClient;
import com.lingosphinx.lesson.domain.LanguageCode;
import com.lingosphinx.lesson.dto.*;
import com.lingosphinx.lesson.mapper.CourseMapper;
import com.lingosphinx.lesson.mapper.LessonMapper;
import com.lingosphinx.lesson.mapper.UnitMapper;
import com.lingosphinx.lesson.repository.CourseRepository;
import com.lingosphinx.lesson.repository.LessonRepository;
import com.lingosphinx.lesson.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class CarouselServiceImpl implements CarouselService {

    private final GamificationClient gamificationClient;
    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    
    
    protected List<Long> extractReferences(List<com.lingosphinx.gamification.dto.GoalDto> goals) {
        return goals.stream()
                .map(goal -> goal.getDefinition().getReference())
                .map(Long::parseLong)
                .toList();
    }

    @Override
    public LessonCarousel lessonCarousel(LanguageCode language) {
        var goals = gamificationClient.getGoals(language.getValue(), "lesson");
        var references = extractReferences(goals);
        var lessons = lessonRepository.findAllById(references)
                .stream()
                .map(lessonMapper::toDto)
                .toList();

        return LessonCarousel.zipped(lessons, goals);
    }

    @Override
    public UnitCarousel unitCarousel(LanguageCode language) {
        var goals = gamificationClient.getGoals(language.getValue(), "unit");
        var references = extractReferences(goals);
        var units = unitRepository.findAllById(references)
                .stream()
                .map(unitMapper::toDto)
                .toList();

        return UnitCarousel.zipped(units, goals);
    }

    @Override
    public CourseCarousel courseCarousel(LanguageCode language) {
        var goals = gamificationClient.getGoals(language.getValue(), "course");
        var references = extractReferences(goals);
        var courses = courseRepository.findAllById(references)
                .stream()
                .map(courseMapper::toDto)
                .toList();

        return CourseCarousel.zipped(courses, goals);
    }
}