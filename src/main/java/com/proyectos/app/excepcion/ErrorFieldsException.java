package com.proyectos.app.excepcion;

import java.util.List;
import java.util.Properties;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ErrorFieldsException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private List<Properties> errors;

    public ErrorFieldsException(String message, List<Properties> errors) {
        super(message);
        this.errors = errors;
    }
}