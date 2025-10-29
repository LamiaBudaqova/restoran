package com.backend.restoran.services;

import com.backend.restoran.dtos.request.ContactMessageRequestDto;
import com.backend.restoran.dtos.response.ContactMessageResponseDto;

import java.util.List;

public interface ContactMessageService {
    List<ContactMessageResponseDto> getAll();
    ContactMessageResponseDto getById(Long id);
    ContactMessageResponseDto create(ContactMessageRequestDto request);
    ContactMessageResponseDto update(Long id, ContactMessageRequestDto request);
    void delete(Long id);
}
