package com.lingosphinx.lesson.repository;

import com.lingosphinx.lesson.domain.LessonType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonTypeRepository extends JpaRepository<LessonType, Long> {}
