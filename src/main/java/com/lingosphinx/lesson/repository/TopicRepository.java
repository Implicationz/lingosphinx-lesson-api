package com.lingosphinx.lesson.repository;

import com.lingosphinx.lesson.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {}
