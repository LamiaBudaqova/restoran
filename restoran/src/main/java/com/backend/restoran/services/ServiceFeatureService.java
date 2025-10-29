package com.backend.restoran.services;

import com.backend.restoran.dtos.request.ServiceFeatureRequestDto;
import com.backend.restoran.dtos.response.ServiceFeatureResponseDto;

import java.util.List;

public interface ServiceFeatureService {
    List<ServiceFeatureResponseDto> getAll();
    ServiceFeatureResponseDto getById(Long id);
    ServiceFeatureResponseDto create(ServiceFeatureRequestDto request);
    ServiceFeatureResponseDto update(Long id, ServiceFeatureRequestDto request);
    void delete(Long id);
}
