package com.backend.restoran.controllers;

import com.backend.restoran.dtos.request.TeamMemberRequestDto;
import com.backend.restoran.dtos.response.TeamMemberResponseDto;
import com.backend.restoran.services.TeamMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team-members")
public class TeamMemberController {

    private final TeamMemberService teamMemberService;

    @GetMapping
    public List<TeamMemberResponseDto> getAll(){
        return teamMemberService.getAll();
    }

    @GetMapping("/{id}")
    public TeamMemberResponseDto getById(@PathVariable Long id){
        return teamMemberService.getById(id);
    }

    @PostMapping
    public TeamMemberResponseDto create(@RequestBody TeamMemberRequestDto request){
        return teamMemberService.create(request);
    }

    @PutMapping("/{id}")
    public TeamMemberResponseDto update(@PathVariable Long id,
                                        @RequestBody TeamMemberRequestDto request){
        return teamMemberService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public  void delete(@PathVariable Long id){
        teamMemberService.delete(id);
    }
}
