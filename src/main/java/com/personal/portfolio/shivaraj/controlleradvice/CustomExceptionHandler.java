package com.personal.portfolio.shivaraj.controlleradvice;

import com.personal.portfolio.shivaraj.exception.ServiceNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<Object> handleServiceNotFoundException(ServiceNotFoundException serviceNotFoundException){
        Map<String, Object> errorBody = new LinkedHashMap<>();
        errorBody.put("status", "error");
        errorBody.put("message", serviceNotFoundException.getMessage());
        return ResponseEntity.status(404).body(errorBody);
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException){
        Map<String, Object> errorBody = new LinkedHashMap<>();
        errorBody.put("status", "error");
        errorBody.put("message", emptyResultDataAccessException.getMessage());
        return ResponseEntity.status(404).body(errorBody);
    }
}
