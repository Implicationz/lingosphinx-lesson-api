package com.lingosphinx.lesson.repository;

import com.lingosphinx.lesson.domain.Topic;
import com.lingosphinx.lesson.domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Long> {}
