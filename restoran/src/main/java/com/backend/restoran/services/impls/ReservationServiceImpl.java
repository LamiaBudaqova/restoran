package com.backend.restoran.services.impls;

import com.backend.restoran.dtos.request.ReservationRequestDto;
import com.backend.restoran.dtos.response.ReservationResponseDto;
import com.backend.restoran.models.Reservation;
import com.backend.restoran.repositories.ReservationRepository;
import com.backend.restoran.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ReservationResponseDto> getAll() {
        return reservationRepository.findAll()
                .stream()
                .map(reservation -> modelMapper.map(reservation,ReservationResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationResponseDto getById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rezerv tapılmadı"));
        return modelMapper.map(reservation, ReservationResponseDto.class);
    }

    @Override
    public ReservationResponseDto create(ReservationRequestDto request) {
        Reservation reservation = modelMapper.map(request, Reservation.class);
        Reservation saved = reservationRepository.save(reservation);
        return modelMapper.map(saved, ReservationResponseDto.class);
    }

    @Override
    public ReservationResponseDto update(Long id, ReservationRequestDto request) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rezerv tapılmadı"));
        modelMapper.map(request, reservation);
        Reservation updated = reservationRepository.save(reservation);
        return modelMapper.map(updated, ReservationResponseDto.class);
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}
