package com.backend.restoran.services.impls;

import com.backend.restoran.dtos.request.AboutRequestDto;
import com.backend.restoran.dtos.response.AboutResponseDto;
import com.backend.restoran.models.About;
import com.backend.restoran.repositories.AboutRepository;
import com.backend.restoran.services.AboutService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService {

    private final AboutRepository aboutRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AboutResponseDto> getAll() {
        return aboutRepository.findAll()
                .stream()
                .map(about -> modelMapper.map(about, AboutResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AboutResponseDto getById(Long id) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Məlumat tapılmadı"));
        return modelMapper.map(about, AboutResponseDto.class);
    }

    @Override
    public AboutResponseDto create(AboutRequestDto request) {
        About about = modelMapper.map(request, About.class);
        aboutRepository.save(about);
        return modelMapper.map(about, AboutResponseDto.class);
    }

    @Override
    public AboutResponseDto update(Long id, AboutRequestDto request) {
        About about = aboutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Məlumat tapılmadı"));
        modelMapper.map(request, about);
        aboutRepository.save(about);
        return modelMapper.map(about, AboutResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        aboutRepository.deleteById(id);
    }
}
