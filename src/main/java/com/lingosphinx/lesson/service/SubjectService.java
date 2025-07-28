package com.lingosphinx.lesson.service;

import com.lingosphinx.lesson.dto.SubjectDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SubjectService {
    SubjectDto create(SubjectDto subject);
    SubjectDto readById(Long id);
    List<SubjectDto> readAll();

    @Transactional(readOnly = true)
    List<SubjectDto> readAll(String name);

    SubjectDto update(Long id, SubjectDto subject);
    void delete(Long id);
}
