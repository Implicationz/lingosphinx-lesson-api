package com.lingosphinx.lesson.repository;

import com.lingosphinx.lesson.domain.Material;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MaterialRepository extends JpaRepository<Material, Long> {
    @EntityGraph(attributePaths = {"lesson", "lesson.unit", "lesson.unit.course", "lesson.subject", "lesson.topic"})
    @Override
    Optional<Material> findById(Long id);
}
