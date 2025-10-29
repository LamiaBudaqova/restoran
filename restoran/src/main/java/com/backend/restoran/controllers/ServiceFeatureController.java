package com.backend.restoran.controllers;

import com.backend.restoran.dtos.request.ServiceFeatureRequestDto;
import com.backend.restoran.dtos.response.ServiceFeatureResponseDto;
import com.backend.restoran.services.ServiceFeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-features")
public class ServiceFeatureController {

    private final ServiceFeatureService serviceFeatureService;

    @GetMapping
    public List<ServiceFeatureResponseDto> getAll() {
        return serviceFeatureService.getAll();
    }

    @GetMapping("/{id}")
    public ServiceFeatureResponseDto getById(@PathVariable Long id) {
        return serviceFeatureService.getById(id);
    }

    @PostMapping
    public ServiceFeatureResponseDto create(@RequestBody ServiceFeatureRequestDto request) {
        return serviceFeatureService.create(request);
    }

    @PutMapping("/{id}")
    public ServiceFeatureResponseDto update(@PathVariable Long id,
                                            @RequestBody ServiceFeatureRequestDto request) {
        return serviceFeatureService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        serviceFeatureService.delete(id);
    }
}
