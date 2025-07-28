package com.lingosphinx.lesson.repository;

import com.lingosphinx.lesson.domain.Unit;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    @EntityGraph(attributePaths = {"course", "subject", "topic", "lessons"})
    @Override
    Optional<Unit> findById(Long id);
}
