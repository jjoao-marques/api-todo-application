package com.marques.projecttodo.Controller.exceptions;

import com.marques.projecttodo.Messages.MessageUtil;
import com.marques.projecttodo.services.exceptions.InvalidDate;
import com.marques.projecttodo.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> fieldTitle (MethodArgumentNotValidException e) {
        ValidationError error = new ValidationError (System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(), MessageUtil.ERROR_FIELD_VALIDATION);
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            error.addErrors(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(InvalidDate.class)
    public ResponseEntity<StandardError> invalidDate(InvalidDate e) {
        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
