package com.jeyster.gestionnaire_collection_tcg.controller;

import com.jeyster.gestionnaire_collection_tcg.exception.AlreadyExistingObjectException;
import com.jeyster.gestionnaire_collection_tcg.exception.NotExistingObjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistingObjectException.class)
    public ResponseEntity<ProblemDetail> handleAlreadyExists(AlreadyExistingObjectException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.CONFLICT,
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(problem);
    }

    @ExceptionHandler(NotExistingObjectException.class)
    public ResponseEntity<ProblemDetail> handleNotExisting(NotExistingObjectException ex) {
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problem);
    }
}
