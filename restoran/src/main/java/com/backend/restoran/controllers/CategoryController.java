package com.backend.restoran.controllers;

import com.backend.restoran.dtos.request.CategoryRequestDto;
import com.backend.restoran.dtos.response.CategoryResponseDto;
import com.backend.restoran.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // butun kateqoriyaları getir (GET /api/categories)
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAll() {
        List<CategoryResponseDto> categories = categoryService.getAll();
        return ResponseEntity.ok(categories);
    }

    // idyə gore bir kateqoriya getir (GET /api/categories/{id})
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getById(@PathVariable Long id) {
        CategoryResponseDto category = categoryService.getById(id);
        return ResponseEntity.ok(category);
    }

    // yeni kateqoriya elave et (POST /api/categories)
    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryRequestDto request) {
        CategoryResponseDto created = categoryService.create(request);
        return ResponseEntity.ok(created);
    }

    // movcud kateqoriyanı yenile (PUT /api/categories/{id})
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> update(
            @PathVariable Long id,
            @RequestBody CategoryRequestDto request
    ) {
        CategoryResponseDto updated = categoryService.update(id, request);
        return ResponseEntity.ok(updated);
    }

    //  Kateqoriyanı sil (DELETE /api/categories/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
