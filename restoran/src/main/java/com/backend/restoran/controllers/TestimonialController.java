package com.backend.restoran.controllers;

import com.backend.restoran.dtos.request.TestimonialRequestDto;
import com.backend.restoran.dtos.response.TestimonialResponseDto;
import com.backend.restoran.services.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/testimonials")
public class TestimonialController {

    private final TestimonialService testimonialService;

    @GetMapping
    public List<TestimonialResponseDto> getAll() {
        return testimonialService.getAll();
    }

    @GetMapping("/{id}")
    public TestimonialResponseDto getById(@PathVariable Long id) {
        return testimonialService.getById(id);
    }

    @PostMapping
    public TestimonialResponseDto create(@RequestBody TestimonialRequestDto request) {
        return testimonialService.create(request);
    }

    @PutMapping("/{id}")
    public TestimonialResponseDto update(@PathVariable Long id, @RequestBody TestimonialRequestDto request) {
        return testimonialService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        testimonialService.delete(id);
    }
}
