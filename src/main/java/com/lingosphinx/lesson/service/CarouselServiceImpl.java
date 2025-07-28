package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.client.GamificationClient;
import com.lingosphinx.lesson.domain.LanguageCode;
import com.lingosphinx.lesson.dto.CourseCarousel;
import com.lingosphinx.lesson.dto.LessonCarousel;
import com.lingosphinx.lesson.dto.UnitCarousel;
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

    protected List<Long> readGoalIds(LanguageCode language, String type) {
        var goals = gamificationClient.getGoals(language.getValue(), type);
        var references = goals.stream().map(goal -> goal.getDefinition().getReference());
        return references.map(Long::parseLong).toList();
    }

    @Override
    public LessonCarousel lessonCarousel(LanguageCode language) {
        var found = lessonRepository.findAllById(readGoalIds(language, "lesson"));
        var items = found.stream().map(lessonMapper::toDto).toList();
        return LessonCarousel.builder().items(items).build();
    }

    @Override
    public UnitCarousel unitCarousel(LanguageCode language) {
        var found = unitRepository.findAllById(readGoalIds(language, "unit"));
        var items = found.stream().map(unitMapper::toDto).toList();
        return UnitCarousel.builder().items(items).build();
    }

    @Override
    public CourseCarousel courseCarousel(LanguageCode language) {
        var found = courseRepository.findAllById(readGoalIds(language, "course"));
        var items = found.stream().map(courseMapper::toDto).toList();
        return CourseCarousel.builder().items(items).build();
    }
}