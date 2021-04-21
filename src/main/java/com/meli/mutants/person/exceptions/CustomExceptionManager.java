package com.meli.mutants.person.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class CustomExceptionManager extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotContainProtein.class)
    public ResponseEntity<ErrorMessagesStructure> handleNoProtein(NotContainProtein ex) {
        log.info("Error handleNoProtein : {}", ex.getMessage());
        ErrorMessagesStructure error = new ErrorMessagesStructure(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }


    @ExceptionHandler(LengthProteinWrong.class)
    public ResponseEntity<ErrorMessagesStructure> handleLengthProteinWrong(LengthProteinWrong ex) {
        log.info("Error handleLengthProteinWrong : {}", ex.getMessage());
        ErrorMessagesStructure error = new ErrorMessagesStructure(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex.getMessage());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }


    @ExceptionHandler(ProteinExistInDataBase.class)
    public ResponseEntity<ErrorMessagesStructure> handleLengthProteinWrong(ProteinExistInDataBase ex) {
        log.info("Error handleLengthProteinWrong : {}", ex.getMessage());
        ErrorMessagesStructure error = new ErrorMessagesStructure(HttpStatus.CONFLICT, ex.getLocalizedMessage(), ex.getMessage());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, new HttpHeaders(), error.getStatus());
    }


}
