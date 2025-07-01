package com.lingosphinx.lesson.repository;


import com.lingosphinx.lesson.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {}
