package com.lingosphinx.lesson.repository;

import com.lingosphinx.lesson.domain.Lesson;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @EntityGraph(attributePaths = {"unit", "subject", "topic", "materials"})
    @Override
    Optional<Lesson> findById(Long id);
}
