package com.lingosphinx.lesson.repository;

import com.lingosphinx.lesson.domain.Summary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SummaryRepository extends JpaRepository<Summary, Long> {
    @EntityGraph(attributePaths = {"translations"})
    @Override
    Optional<Summary> findById(Long id);
}
