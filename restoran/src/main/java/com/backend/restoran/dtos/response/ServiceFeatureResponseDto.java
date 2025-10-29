package com.backend.restoran.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceFeatureResponseDto {
    private Long id;
    private String title;
    private String description;
    private String icon;
}
