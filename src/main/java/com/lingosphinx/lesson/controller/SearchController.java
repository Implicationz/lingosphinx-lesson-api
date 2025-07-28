package com.lingosphinx.lesson.controller;


import com.lingosphinx.lesson.domain.CourseSearch;
import com.lingosphinx.lesson.domain.LessonSearch;
import com.lingosphinx.lesson.domain.UnitSearch;
import com.lingosphinx.lesson.service.SearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
@Tag(name = "Search API")
public class SearchController {

    private final SearchService searchService;

    @PostMapping("/lesson")
    public ResponseEntity<LessonSearch> search(@RequestBody @Valid LessonSearch search) {
        return ResponseEntity.status(HttpStatus.CREATED).body(searchService.search(search));
    }

    @PostMapping("/unit")
    public ResponseEntity<UnitSearch> search(@RequestBody @Valid UnitSearch search) {
        return ResponseEntity.status(HttpStatus.CREATED).body(searchService.search(search));
    }

    @PostMapping("/course")
    public ResponseEntity<CourseSearch> search(@RequestBody @Valid CourseSearch search) {
        return ResponseEntity.status(HttpStatus.CREATED).body(searchService.search(search));
    }
}