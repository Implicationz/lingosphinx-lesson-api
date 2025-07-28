package com.lingosphinx.lesson.controller;
import com.lingosphinx.lesson.dto.LessonTypeDto;
import com.lingosphinx.lesson.service.LessonTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lesson-type")
@RequiredArgsConstructor
@Tag(name = "LessonType API")
public class LessonTypeController {

    private final LessonTypeService lessonTypeService;

    @PostMapping
    public ResponseEntity<LessonTypeDto> create(@RequestBody @Valid LessonTypeDto lessonType) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lessonTypeService.create(lessonType));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LessonTypeDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(lessonTypeService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<LessonTypeDto>> readAll() {
        return ResponseEntity.ok(lessonTypeService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<LessonTypeDto> update(@PathVariable Long id, @RequestBody @Valid LessonTypeDto lessonType) {
        return ResponseEntity.ok(lessonTypeService.update(id, lessonType));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        lessonTypeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}