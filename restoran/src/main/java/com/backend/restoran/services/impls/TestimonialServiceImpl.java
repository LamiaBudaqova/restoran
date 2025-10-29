package com.backend.restoran.services.impls;

import com.backend.restoran.dtos.request.TestimonialRequestDto;
import com.backend.restoran.dtos.response.TestimonialResponseDto;
import com.backend.restoran.models.Testimonial;
import com.backend.restoran.repositories.TestimonialRepository;
import com.backend.restoran.services.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialRepository testimonialRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TestimonialResponseDto> getAll() {
        return testimonialRepository.findAll()
                .stream()
                .map(t -> modelMapper.map(t, TestimonialResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TestimonialResponseDto getById(Long id) {
        Testimonial t = testimonialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rəy tapılmadı"));
        return modelMapper.map(t, TestimonialResponseDto.class);
    }

    @Override
    public TestimonialResponseDto create(TestimonialRequestDto request) {
        Testimonial testimonial = modelMapper.map(request, Testimonial.class);
        testimonialRepository.save(testimonial);
        return modelMapper.map(testimonial, TestimonialResponseDto.class);
    }

    @Override
    public TestimonialResponseDto update(Long id, TestimonialRequestDto request) {
        Testimonial testimonial = testimonialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rəy tapılmadı"));
        modelMapper.map(request, testimonial);
        testimonialRepository.save(testimonial);
        return modelMapper.map(testimonial, TestimonialResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        testimonialRepository.deleteById(id);
    }
}