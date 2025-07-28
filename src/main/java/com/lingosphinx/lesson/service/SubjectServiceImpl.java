package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.dto.SubjectDto;
import com.lingosphinx.lesson.exception.ResourceNotFoundException;
import com.lingosphinx.lesson.mapper.SubjectMapper;
import com.lingosphinx.lesson.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public SubjectDto create(SubjectDto subjectDto) {
        var subject = subjectMapper.toEntity(subjectDto);
        var savedSubject = subjectRepository.save(subject);
        return subjectMapper.toDto(savedSubject);
    }

    @Override
    @Transactional(readOnly = true)
    public SubjectDto readById(Long id) {
        var subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));
        return subjectMapper.toDto(subject);
    }

    @Override
    @Cacheable("subjects")
    @Transactional(readOnly = true)
    public List<SubjectDto> readAll() {
        return subjectRepository.findAll().stream()
                .map(subjectMapper::toDto)
                .toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<SubjectDto> readAll(String name) {
        var subjects = subjectRepository.findByNameStartingWithIgnoreCase(name);
        return subjects.stream().map(subjectMapper::toDto).toList();
    }

    @Override
    public SubjectDto update(Long id, SubjectDto subjectDto) {
        var existingSubject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found"));

        var savedSubject = subjectRepository.save(existingSubject);
        return subjectMapper.toDto(savedSubject);
    }

    @Override
    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
}