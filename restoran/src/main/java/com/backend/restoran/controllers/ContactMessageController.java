package com.backend.restoran.controllers;

import com.backend.restoran.dtos.request.ContactMessageRequestDto;
import com.backend.restoran.dtos.response.ContactMessageResponseDto;
import com.backend.restoran.services.ContactMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contact-messages")
@RequiredArgsConstructor
public class ContactMessageController {

    private final ContactMessageService contactMessageService;

    @GetMapping
    public List<ContactMessageResponseDto> getAll() {
        return contactMessageService.getAll();
    }

    @GetMapping("/{id}")
    public ContactMessageResponseDto getById(@PathVariable Long id) {
        return contactMessageService.getById(id);
    }

    @PostMapping
    public ContactMessageResponseDto create(@RequestBody ContactMessageRequestDto request) {
        return contactMessageService.create(request);
    }

    @PutMapping("/{id}")
    public ContactMessageResponseDto update(@PathVariable Long id, @RequestBody ContactMessageRequestDto request) {
        return contactMessageService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contactMessageService.delete(id);
    }
}
