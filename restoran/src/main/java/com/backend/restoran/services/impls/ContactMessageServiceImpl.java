package com.backend.restoran.services.impls;

import com.backend.restoran.dtos.request.ContactMessageRequestDto;
import com.backend.restoran.dtos.response.ContactMessageResponseDto;
import com.backend.restoran.models.ContactMessage;
import com.backend.restoran.repositories.ContactMessageRepository;
import com.backend.restoran.services.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {
    private final ContactMessageRepository contactMessageRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ContactMessageResponseDto> getAll() {
        return contactMessageRepository.findAll()
                .stream()
                .map(m -> modelMapper.map(m, ContactMessageResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ContactMessageResponseDto getById(Long id) {
        ContactMessage message = contactMessageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesaj tapılmadı"));
        return modelMapper.map(message, ContactMessageResponseDto.class);
    }

    @Override
    public ContactMessageResponseDto create(ContactMessageRequestDto request) {
        ContactMessage message = modelMapper.map(request, ContactMessage.class);
        contactMessageRepository.save(message);
        return modelMapper.map(message, ContactMessageResponseDto.class);
    }

    @Override
    public ContactMessageResponseDto update(Long id, ContactMessageRequestDto request) {
        ContactMessage message = contactMessageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesaj tapılmadı"));
        modelMapper.map(request, message);
        contactMessageRepository.save(message);
        return modelMapper.map(message, ContactMessageResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        contactMessageRepository.deleteById(id);
    }
}