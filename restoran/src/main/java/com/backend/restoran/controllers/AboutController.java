package com.backend.restoran.controllers;

import com.backend.restoran.dtos.request.AboutRequestDto;
import com.backend.restoran.dtos.response.AboutResponseDto;
import com.backend.restoran.services.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor
public class AboutController {

    private final AboutService aboutService;

    @GetMapping
    public List<AboutResponseDto> getAll() {
        return aboutService.getAll();
    }

    @GetMapping("/{id}")
    public AboutResponseDto getById(@PathVariable Long id) {
        return aboutService.getById(id);
    }

    @PostMapping
    public AboutResponseDto create(@RequestBody AboutRequestDto request) {
        return aboutService.create(request);
    }

    @PutMapping("/{id}")
    public AboutResponseDto update(@PathVariable Long id, @RequestBody AboutRequestDto request) {
        return aboutService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        aboutService.delete(id);
    }
}
