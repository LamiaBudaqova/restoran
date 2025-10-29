package com.backend.restoran.services;

import com.backend.restoran.dtos.request.TestimonialRequestDto;
import com.backend.restoran.dtos.response.TestimonialResponseDto;

import java.util.List;

public interface TestimonialService {
    List<TestimonialResponseDto> getAll();
    TestimonialResponseDto getById(Long id);
    TestimonialResponseDto create(TestimonialRequestDto request);
    TestimonialResponseDto update(Long id, TestimonialRequestDto request);
    void delete(Long id);
}
