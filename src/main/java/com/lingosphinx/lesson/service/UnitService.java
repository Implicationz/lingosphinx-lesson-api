package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.dto.UnitDto;

import java.util.List;

public interface UnitService {
    UnitDto create(UnitDto unit);
    UnitDto readById(Long id);
    List<UnitDto> readAll();
    UnitDto update(Long id, UnitDto unit);
    void delete(Long id);
}
