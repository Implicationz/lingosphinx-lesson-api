package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.dto.MaterialDto;

import java.util.List;

public interface MaterialService {
    MaterialDto create(MaterialDto material);
    MaterialDto readById(Long id);
    List<MaterialDto> readAll();
    MaterialDto update(Long id, MaterialDto material);
    void delete(Long id);
}
