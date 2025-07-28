package com.lingosphinx.lesson.controller;


import com.lingosphinx.lesson.domain.LanguageCode;
import com.lingosphinx.lesson.dto.CourseCarousel;
import com.lingosphinx.lesson.dto.LessonCarousel;
import com.lingosphinx.lesson.dto.UnitCarousel;
import com.lingosphinx.lesson.service.CarouselService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carousel")
@RequiredArgsConstructor
@Tag(name = "Carousel API")
public class CarouselController {

    private final CarouselService carouselService;

    @GetMapping("/lesson/{language}")
    public ResponseEntity<LessonCarousel> lessonCarousel(@PathVariable String language) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carouselService.lessonCarousel(LanguageCode.valueOf(language)));
    }

    @GetMapping("/unit/{language}")
    public ResponseEntity<UnitCarousel> unitCarousel(@PathVariable String language) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carouselService.unitCarousel(LanguageCode.valueOf(language)));
    }

    @GetMapping("/course/{language}")
    public ResponseEntity<CourseCarousel> courseCarousel(@PathVariable String language) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carouselService.courseCarousel(LanguageCode.valueOf(language)));
    }
}