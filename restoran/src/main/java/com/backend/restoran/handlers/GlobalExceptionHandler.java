package com.backend.restoran.handlers;

import com.backend.restoran.exceptions.BaseException;
import com.backend.restoran.exceptions.ErrorsType;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorsApi<String>> handleBaseException(BaseException ex, WebRequest request) {
        return ResponseEntity.badRequest().body(createErrorsApi(ex.getMessage(), request));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorsApi<String>> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream().map(err -> err.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.badRequest().body(createErrorsApi(errorMessage, request));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorsApi<String>> handleDataIntegrityViolation(DataIntegrityViolationException ex, WebRequest request) {
        String errorMessage = ErrorsType.UNIQUE_CONSTRAINT.getMessage();
        return ResponseEntity.badRequest().body(createErrorsApi(errorMessage, request));
    }

    private String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return "unknown-host";
        }
    }

    private <E> ErrorsApi<E> createErrorsApi(E message, WebRequest webRequest) {
        ErrorsApi<E> errorsApi = new ErrorsApi<>();
        errorsApi.setCode(HttpStatus.BAD_REQUEST.value());

        ExceptionDetail<E> exceptionDetail = new ExceptionDetail<>();
        exceptionDetail.setCreatedDate(new Date());
        exceptionDetail.setHostName(getHostName());
        exceptionDetail.setPath(webRequest.getDescription(false));
        exceptionDetail.setMessage(message);

        errorsApi.setException(exceptionDetail);
        return errorsApi;
    }
}
