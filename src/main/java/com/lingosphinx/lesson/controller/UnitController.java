package com.lingosphinx.lesson.controller;


import com.lingosphinx.lesson.dto.UnitDto;
import com.lingosphinx.lesson.service.UnitService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unit")
@RequiredArgsConstructor
@Tag(name = "Unit API")
public class UnitController {

    private final UnitService unitService;

    @PostMapping
    public ResponseEntity<UnitDto> create(@RequestBody @Valid UnitDto unit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(unitService.create(unit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(unitService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<UnitDto>> readAll() {
        return ResponseEntity.ok(unitService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitDto> update(@PathVariable Long id, @RequestBody @Valid UnitDto unit) {
        return ResponseEntity.ok(unitService.update(id, unit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        unitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}