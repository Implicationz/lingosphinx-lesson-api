package com.lingosphinx.lesson.service;


import com.lingosphinx.lesson.domain.Unit;
import com.lingosphinx.lesson.dto.CourseDto;
import com.lingosphinx.lesson.dto.UnitDto;
import com.lingosphinx.lesson.exception.ResourceNotFoundException;
import com.lingosphinx.lesson.mapper.CourseMapper;
import com.lingosphinx.lesson.repository.CourseRepository;
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
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseDto create(CourseDto courseDto) {
        var course = courseMapper.toEntity(courseDto);
        var savedCourse = courseRepository.save(course);
        log.info("Course created with id: {}", savedCourse.getId());
        return courseMapper.toDto(savedCourse);
    }

    @Override
    @Transactional(readOnly = true)
    public CourseDto readById(Long id) {
        var course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        log.info("Course found with id: {}", id);
        return courseMapper.toDto(course);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CourseDto> readAll() {
        log.info("Reading all courses");
        return courseRepository.findAll().stream()
                .map(courseMapper::toDto)
                .toList();
    }

    @Override
    public CourseDto update(Long id, CourseDto courseDto) {
        var existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
        courseMapper.updateEntityFromDto(courseDto, existingCourse);
        EntitySyncUtils.syncChildEntities(existingCourse.getUnits(), courseDto.getUnits(),
                Unit::getId,
                UnitDto::getId,
                courseMapper::toEntity,
                unit -> unit.setCourse(existingCourse),
                courseMapper::updateEntityFromDto
                );
        courseRepository.flush();
        log.info("Course updated with id: {}", id);
        return courseMapper.toDto(existingCourse);
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);
        log.info("Course deleted with id: {}", id);
    }
}