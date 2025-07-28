package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.domain.Material;
import com.lingosphinx.lesson.dto.LessonDto;
import com.lingosphinx.lesson.dto.MaterialDto;
import com.lingosphinx.lesson.exception.ResourceNotFoundException;
import com.lingosphinx.lesson.mapper.LessonMapper;
import com.lingosphinx.lesson.repository.LessonRepository;
import com.lingosphinx.lesson.utility.EntitySyncUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public LessonDto create(LessonDto lessonDto) {
        var lesson = lessonMapper.toEntity(lessonDto);
        var savedLesson = lessonRepository.save(lesson);
        log.info("Lesson created with id: {}", savedLesson.getId());
        return lessonMapper.toDto(savedLesson);
    }

    @Override
    @Transactional(readOnly = true)
    public LessonDto readById(Long id) {
        var lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found"));
        
        log.info("Lesson found with id: {}", id);
        return lessonMapper.toDto(lesson);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LessonDto> readAll() {
        log.info("Reading all lessons");
        return lessonRepository.findAll().stream()
                .map(lessonMapper::toDto)
                .toList();
    }

    @Override
    public LessonDto update(Long id, LessonDto lessonDto) {
        var existingLesson = lessonRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lesson not found"));

        lessonMapper.updateEntityFromDto(lessonDto, existingLesson);
        EntitySyncUtils.syncChildEntities(existingLesson.getMaterials(), lessonDto.getMaterials(),
                Material::getId,
                MaterialDto::getId,
                lessonMapper::toEntity,
                material -> material.setLesson(existingLesson),
                lessonMapper::updateEntityFromDto
        );
        lessonRepository.flush();
        log.info("Lesson updated with id: {}", id);
        return lessonMapper.toDto(existingLesson);
    }

    @Override
    public void delete(Long id) {
        lessonRepository.deleteById(id);
        log.info("Lesson deleted with id: {}", id);
    }
}