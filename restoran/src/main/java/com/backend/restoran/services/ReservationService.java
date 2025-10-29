package com.backend.restoran.services;

import com.backend.restoran.dtos.request.ReservationRequestDto;
import com.backend.restoran.dtos.response.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    List<ReservationResponseDto> getAll();
    ReservationResponseDto getById(Long id);
    ReservationResponseDto create(ReservationRequestDto request);
    ReservationResponseDto update(Long id, ReservationRequestDto request);
    void delete(Long id);
}
