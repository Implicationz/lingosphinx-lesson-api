package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.domain.SummaryTranslation;
import com.lingosphinx.lesson.dto.SummaryDto;
import com.lingosphinx.lesson.dto.SummaryTranslationDto;
import com.lingosphinx.lesson.exception.ResourceNotFoundException;
import com.lingosphinx.lesson.mapper.SummaryMapper;
import com.lingosphinx.lesson.repository.SummaryRepository;
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
public class SummaryServiceImpl implements SummaryService {

    private final SummaryRepository summaryRepository;
    private final SummaryMapper summaryMapper;

    @Override
    public SummaryDto create(SummaryDto summaryDto) {
        var summary = summaryMapper.toEntity(summaryDto);
        var savedSummary = summaryRepository.save(summary);
        log.info("Summary created with id: {}", savedSummary.getId());
        return summaryMapper.toDto(savedSummary);
    }

    @Override
    @Transactional(readOnly = true)
    public SummaryDto readById(Long id) {
        var summary = summaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Summary not found"));
        log.info("Summary found with id: {}", id);
        return summaryMapper.toDto(summary);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SummaryDto> readAll() {
        log.info("Reading all summarys");
        return summaryRepository.findAll().stream()
                .map(summaryMapper::toDto)
                .toList();
    }

    @Override
    public SummaryDto update(Long id, SummaryDto summaryDto) {
        var existingSummary = summaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Summary not found"));
        summaryMapper.updateEntityFromDto(summaryDto, existingSummary);
        EntitySyncUtils.syncChildEntities(existingSummary.getTranslations(), summaryDto.getTranslations(),
                SummaryTranslation::getId,
                SummaryTranslationDto::getId,
                summaryMapper::toEntity,
                summaryTranslation -> summaryTranslation.setSummary(existingSummary),
                summaryMapper::updateEntityFromDto
        );
        summaryRepository.flush();
        log.info("Summary updated with id: {}", id);
        return summaryMapper.toDto(existingSummary);
    }

    @Override
    public void delete(Long id) {
        summaryRepository.deleteById(id);
        log.info("Summary deleted with id: {}", id);
    }
}