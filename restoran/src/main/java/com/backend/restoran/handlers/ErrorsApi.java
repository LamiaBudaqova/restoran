package com.backend.restoran.handlers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorsApi<E>{
    private Integer code;
    private ExceptionDetail<E> exception;
}
