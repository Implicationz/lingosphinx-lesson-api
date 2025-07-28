package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.dto.MaterialDto;
import com.lingosphinx.lesson.exception.ResourceNotFoundException;
import com.lingosphinx.lesson.mapper.MaterialMapper;
import com.lingosphinx.lesson.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;

    @Override
    public MaterialDto create(MaterialDto materialDto) {
        var material = materialMapper.toEntity(materialDto);
        var savedMaterial = materialRepository.save(material);
        log.info("Material created with id: {}", savedMaterial.getId());
        return materialMapper.toDto(savedMaterial);
    }

    @Override
    @Transactional(readOnly = true)
    public MaterialDto readById(Long id) {
        var material = materialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Material not found"));
        log.info("Material found with id: {}", id);
        return materialMapper.toDto(material);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MaterialDto> readAll() {
        log.info("Reading all materials");
        return materialRepository.findAll().stream()
                .map(materialMapper::toDto)
                .toList();
    }

    @Override
    public MaterialDto update(Long id, MaterialDto materialDto) {
        var existingMaterial = materialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Material not found"));
        materialMapper.updateEntityFromDto(materialDto, existingMaterial);
        log.info("Material updated with id: {}", id);
        return materialMapper.toDto(existingMaterial);
    }

    @Override
    public void delete(Long id) {
        materialRepository.deleteById(id);
        log.info("Material deleted with id: {}", id);
    }
}