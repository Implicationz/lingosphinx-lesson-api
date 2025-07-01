package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.dto.LessonDto;
import com.lingosphinx.lesson.mapper.LessonMapper;
import com.lingosphinx.lesson.repository.LessonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public LessonDto create(LessonDto lessonDto) {
        var lesson = lessonMapper.toEntity(lessonDto);
        var savedLesson = lessonRepository.save(lesson);
        return lessonMapper.toDto(savedLesson);
    }

    @Override
    @Transactional(readOnly = true)
    public LessonDto readById(Long id) {
        var lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found"));
        return lessonMapper.toDto(lesson);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LessonDto> readAll() {
        return lessonRepository.findAll().stream()
                .map(lessonMapper::toDto)
                .toList();
    }

    @Override
    public LessonDto update(Long id, LessonDto lessonDto) {
        var existingLesson = lessonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lesson not found"));

        var savedLesson = lessonRepository.save(existingLesson);
        return lessonMapper.toDto(savedLesson);
    }

    @Override
    public void delete(Long id) {
        lessonRepository.deleteById(id);
    }
}