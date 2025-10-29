package com.backend.restoran.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamMemberRequestDto {
    private String name;
    private String position;
    private String imageUrl;
    private String description;
    private String instagram;
}
