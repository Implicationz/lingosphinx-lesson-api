package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.dto.LessonTypeDto;
import com.lingosphinx.lesson.exception.ResourceNotFoundException;
import com.lingosphinx.lesson.mapper.LessonTypeMapper;
import com.lingosphinx.lesson.repository.LessonTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LessonTypeServiceImpl implements LessonTypeService {

    private final LessonTypeRepository lessonTypeRepository;
    private final LessonTypeMapper lessonTypeMapper;

    @Override
    public LessonTypeDto create(LessonTypeDto lessonTypeDto) {
        var lessonType = lessonTypeMapper.toEntity(lessonTypeDto);
        var savedLessonType = lessonTypeRepository.save(lessonType);
        log.info("LessonType created with id: {}", savedLessonType.getId());
        return lessonTypeMapper.toDto(savedLessonType);
    }

    @Override
    @Transactional(readOnly = true)
    public LessonTypeDto readById(Long id) {
        var lessonType = lessonTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LessonType not found"));
        log.info("LessonType found with id: {}", id);
        return lessonTypeMapper.toDto(lessonType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LessonTypeDto> readAll() {
        log.info("Reading all lessonTypes");
        return lessonTypeRepository.findAll().stream()
                .map(lessonTypeMapper::toDto)
                .toList();
    }

    @Override
    public LessonTypeDto update(Long id, LessonTypeDto lessonTypeDto) {
        var existingLessonType = lessonTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LessonType not found"));
        var savedLessonType = lessonTypeRepository.save(existingLessonType);
        log.info("LessonType updated with id: {}", id);
        return lessonTypeMapper.toDto(savedLessonType);
    }

    @Override
    public void delete(Long id) {
        lessonTypeRepository.deleteById(id);
        log.info("LessonType deleted with id: {}", id);
    }
}