package com.meli.mutants.person.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class ErrorMessagesStructure {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ErrorMessagesStructure(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }
}
