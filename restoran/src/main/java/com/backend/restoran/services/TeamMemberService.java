package com.backend.restoran.services;

import com.backend.restoran.dtos.request.TeamMemberRequestDto;
import com.backend.restoran.dtos.response.TeamMemberResponseDto;

import java.util.List;

public interface TeamMemberService {
    List<TeamMemberResponseDto> getAll();
    TeamMemberResponseDto getById(Long id);
    TeamMemberResponseDto create(TeamMemberRequestDto request);
    TeamMemberResponseDto update(Long id, TeamMemberRequestDto request);
    void delete(Long id);
}
