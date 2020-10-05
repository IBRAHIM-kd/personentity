package com.person.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class  PersonNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private String message;
    public PersonNotFoundException( String message) {
        this.message = message;
    }
}