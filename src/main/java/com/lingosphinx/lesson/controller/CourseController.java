package com.lingosphinx.lesson.controller;


import com.lingosphinx.lesson.dto.CourseDto;
import com.lingosphinx.lesson.service.CourseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@Tag(name = "Course API")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDto> create(@RequestBody @Valid CourseDto course) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create(course));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> readAll() {
        return ResponseEntity.ok(courseService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> update(@PathVariable Long id, @RequestBody @Valid CourseDto course) {
        return ResponseEntity.ok(courseService.update(id, course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}