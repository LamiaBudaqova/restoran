package com.backend.restoran.services.impls;

import com.backend.restoran.dtos.request.TeamMemberRequestDto;
import com.backend.restoran.dtos.response.TeamMemberResponseDto;
import com.backend.restoran.models.TeamMember;
import com.backend.restoran.repositories.TeamMemberRepository;
import com.backend.restoran.services.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamMemberServiceImpl implements TeamMemberService {

    private final TeamMemberRepository teamMemberRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TeamMemberResponseDto> getAll() {
        return teamMemberRepository.findAll()
                .stream()
                .map(teamMember -> modelMapper.map(teamMember,TeamMemberResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TeamMemberResponseDto getById(Long id) {
        TeamMember teamMember = teamMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Üzv tapılmadı"));
        return modelMapper.map(teamMember, TeamMemberResponseDto.class);
    }

    @Override
    public TeamMemberResponseDto create(TeamMemberRequestDto request) {
        TeamMember teamMember = modelMapper.map(request, TeamMember.class);
        teamMemberRepository.save(teamMember);
        return modelMapper.map(teamMember, TeamMemberResponseDto.class);
    }

    @Override
    public TeamMemberResponseDto update(Long id, TeamMemberRequestDto request) {
        TeamMember teamMember = teamMemberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Üzv tapılmadı"));
        modelMapper.map(request, teamMember);
        teamMemberRepository.save(teamMember);
        return modelMapper.map(teamMember, TeamMemberResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        teamMemberRepository.deleteById(id);
    }
}
