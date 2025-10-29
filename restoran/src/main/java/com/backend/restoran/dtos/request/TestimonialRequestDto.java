package com.backend.restoran.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestimonialRequestDto {
    private String clientName;
    private String profession;
    private String feedback;
    private String imageUrl;
}
