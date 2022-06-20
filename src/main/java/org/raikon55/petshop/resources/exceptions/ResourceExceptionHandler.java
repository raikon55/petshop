package org.raikon55.petshop.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.raikon55.petshop.service.exceptions.DataIntegrityException;
import org.raikon55.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjetoNaoEncontradoException error,
            HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), error.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException error,
            HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), error.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(err);
    }
}
