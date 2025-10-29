package com.backend.restoran.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamMemberResponseDto {
    private Long id;
    private String name;
    private String position;
    private String imageUrl;
    private String description;
    private String instagram;
}
