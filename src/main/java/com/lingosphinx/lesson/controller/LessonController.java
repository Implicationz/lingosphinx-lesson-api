package com.lingosphinx.lesson.controller;

import com.lingosphinx.lesson.dto.LessonDto;
import com.lingosphinx.lesson.service.LessonService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson")
@RequiredArgsConstructor
@Tag(name = "Lesson API")
public class LessonController {

    private final LessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonDto> create(@RequestBody @Valid LessonDto lesson) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonService.create(lesson));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<LessonDto>> readAll() {
        return ResponseEntity.ok(lessonService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonDto> update(@PathVariable Long id, @RequestBody @Valid LessonDto lesson) {
        return ResponseEntity.ok(lessonService.update(id, lesson));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lessonService.delete(id);
        return ResponseEntity.noContent().build();
    }
}