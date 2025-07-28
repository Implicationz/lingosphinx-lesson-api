package com.lingosphinx.lesson.controller;


import com.lingosphinx.lesson.dto.MaterialDto;
import com.lingosphinx.lesson.service.MaterialService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
@RequiredArgsConstructor
@Tag(name = "Material API")
public class MaterialController {

    private final MaterialService materialService;

    @PostMapping
    public ResponseEntity<MaterialDto> create(@RequestBody @Valid MaterialDto material) {
        return ResponseEntity.status(HttpStatus.CREATED).body(materialService.create(material));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDto> readById(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.readById(id));
    }

    @GetMapping
    public ResponseEntity<List<MaterialDto>> readAll() {
        return ResponseEntity.ok(materialService.readAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaterialDto> update(@PathVariable Long id, @RequestBody @Valid MaterialDto material) {
        return ResponseEntity.ok(materialService.update(id, material));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        materialService.delete(id);
        return ResponseEntity.noContent().build();
    }
}