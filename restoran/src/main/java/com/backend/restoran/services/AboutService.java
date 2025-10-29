package com.backend.restoran.services;

import com.backend.restoran.dtos.request.AboutRequestDto;
import com.backend.restoran.dtos.response.AboutResponseDto;

import java.util.List;

public interface AboutService {
    List<AboutResponseDto> getAll();
    AboutResponseDto getById(Long id);
    AboutResponseDto create(AboutRequestDto request);
    AboutResponseDto update(Long id, AboutRequestDto request);
    void delete(Long id);
}
