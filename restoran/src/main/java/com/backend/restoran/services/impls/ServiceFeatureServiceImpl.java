package com.backend.restoran.services.impls;

import com.backend.restoran.dtos.request.ServiceFeatureRequestDto;
import com.backend.restoran.dtos.response.ServiceFeatureResponseDto;
import com.backend.restoran.models.ServiceFeature;
import com.backend.restoran.repositories.ServiceFeatureRepository;
import com.backend.restoran.services.ServiceFeatureService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceFeatureServiceImpl implements ServiceFeatureService {

    private final ServiceFeatureRepository repository;
    private final ModelMapper modelMapper;

    @Override
    public List<ServiceFeatureResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(feature -> modelMapper.map(feature, ServiceFeatureResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ServiceFeatureResponseDto getById(Long id) {
        ServiceFeature feature = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Xidmət tapılmadı"));
        return modelMapper.map(feature, ServiceFeatureResponseDto.class);
    }

    @Override
    public ServiceFeatureResponseDto create(ServiceFeatureRequestDto request) {
        ServiceFeature feature = modelMapper.map(request, ServiceFeature.class);
        repository.save(feature);
        return modelMapper.map(feature, ServiceFeatureResponseDto.class);
    }

    @Override
    public ServiceFeatureResponseDto update(Long id, ServiceFeatureRequestDto request) {
        ServiceFeature feature = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Xidmət tapılmadı"));
        modelMapper.map(request, feature);
        repository.save(feature);
        return modelMapper.map(feature, ServiceFeatureResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
