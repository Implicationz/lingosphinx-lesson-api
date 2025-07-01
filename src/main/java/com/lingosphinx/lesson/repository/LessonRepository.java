package com.lingosphinx.lesson.repository;

import com.lingosphinx.lesson.domain.Lesson;
import com.lingosphinx.lesson.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {}
