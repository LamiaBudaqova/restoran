package com.backend.restoran.services;

import com.backend.restoran.dtos.request.CategoryRequestDto;
import com.backend.restoran.dtos.response.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    List<CategoryResponseDto> getAll();
    CategoryResponseDto getById(Long id);
    CategoryResponseDto create(CategoryRequestDto request);
    CategoryResponseDto update(Long id, CategoryRequestDto request);
    void delete(Long id);
}
