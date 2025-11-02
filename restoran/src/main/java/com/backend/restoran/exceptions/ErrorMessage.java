package com.backend.restoran.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private ErrorsType errorsType;
    private String detail;

    public String errorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(errorsType.getMessage());
        if (detail != null) {
            builder.append(" : ").append(detail);
        }
        return builder.toString();
    }
}
