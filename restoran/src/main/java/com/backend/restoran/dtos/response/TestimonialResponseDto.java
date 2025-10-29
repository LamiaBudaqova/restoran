package com.backend.restoran.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialResponseDto {
    private Long id;
    private String clientName;
    private String profession;
    private String feedback;
    private String imageUrl;
}
