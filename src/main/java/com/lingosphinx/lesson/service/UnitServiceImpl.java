package com.lingosphinx.lesson.service;


import com.lingosphinx.lesson.domain.Lesson;
import com.lingosphinx.lesson.dto.LessonDto;
import com.lingosphinx.lesson.dto.UnitDto;
import com.lingosphinx.lesson.exception.ResourceNotFoundException;
import com.lingosphinx.lesson.mapper.UnitMapper;
import com.lingosphinx.lesson.repository.UnitRepository;
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
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;

    @Override
    public UnitDto create(UnitDto unitDto) {
        var unit = unitMapper.toEntity(unitDto);
        var savedUnit = unitRepository.save(unit);
        log.info("Unit created with id: {}", savedUnit.getId());
        return unitMapper.toDto(savedUnit);
    }

    @Override
    @Transactional(readOnly = true)
    public UnitDto readById(Long id) {
        var unit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found"));
        log.info("Unit found with id: {}", id);
        return unitMapper.toDto(unit);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UnitDto> readAll() {
        log.info("Reading all units");
        return unitRepository.findAll().stream()
                .map(unitMapper::toDto)
                .toList();
    }

    @Override
    public UnitDto update(Long id, UnitDto unitDto) {
        var existingUnit = unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Unit not found"));
        unitMapper.updateEntityFromDto(unitDto, existingUnit);
        EntitySyncUtils.syncChildEntities(existingUnit.getLessons(), unitDto.getLessons(),
                Lesson::getId,
                LessonDto::getId,
                unitMapper::toEntity,
                lesson -> lesson.setUnit(existingUnit),
                unitMapper::updateEntityFromDto
        );
        unitRepository.flush();
        log.info("Unit updated with id: {}", id);
        return unitMapper.toDto(existingUnit);
    }

    @Override
    public void delete(Long id) {
        unitRepository.deleteById(id);
        log.info("Unit deleted with id: {}", id);
    }
}