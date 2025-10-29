package com.backend.restoran.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactMessageResponseDto {
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String message;
}
