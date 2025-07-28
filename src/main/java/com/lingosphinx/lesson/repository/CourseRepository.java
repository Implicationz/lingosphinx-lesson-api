package com.lingosphinx.lesson.repository;

import com.lingosphinx.lesson.domain.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @EntityGraph(attributePaths = {"subject", "topic", "units"})
    @Override
    Optional<Course> findById(Long id);
}
