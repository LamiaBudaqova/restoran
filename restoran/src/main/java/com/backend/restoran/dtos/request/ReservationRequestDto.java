package com.backend.restoran.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDto {
    private String fullName;
    private String email;
    private String phone;
    private LocalDate date;
    private LocalTime time;
    private int peopleCount;
    private String message;
}
