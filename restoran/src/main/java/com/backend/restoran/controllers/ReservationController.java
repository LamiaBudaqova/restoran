package com.backend.restoran.controllers;

import com.backend.restoran.dtos.request.ReservationRequestDto;
import com.backend.restoran.dtos.response.ReservationResponseDto;
import com.backend.restoran.repositories.ReservationRepository;
import com.backend.restoran.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public List<ReservationResponseDto> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public ReservationResponseDto getById(@PathVariable Long id){
        return reservationService.getById(id);
    }

    @PostMapping
    public ReservationResponseDto create(@RequestBody ReservationRequestDto request){
        return reservationService.create(request);
    }

    @PutMapping("/{id}")
    public ReservationResponseDto update(@PathVariable Long id,
                                         @RequestBody ReservationRequestDto request){
        return reservationService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        reservationService.delete(id);
    }
}
