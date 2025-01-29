package com.espe.micro_miembros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Iteramos sobre todos los errores
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            // Solo agregamos el mensaje personalizado de cada campo
            errors.put(error.getField(), error.getDefaultMessage());
        });

        // Devolvemos el mensaje de error
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
