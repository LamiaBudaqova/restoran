package com.backend.restoran.dtos.request;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemRequestDto {
    private String name;  //meselen pizza margherita
    private String description;
    private Double price;
    private String imageUrl;
    private Long categoryId; // cateqoriyanın IDsini gonderirik
}
