package com.example.demo.utils;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.model.ErrorInfo;

@RestControllerAdvice
public class ExceptionAdvice {

	
	
	@ExceptionHandler(exception = RuntimeException.class)
	public ErrorInfo handleRunTimeException(Exception ex, WebRequest request) {
		
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(), 
				request.getDescription(false));
	}
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> entityValidationException(BindException ex, WebRequest request) {
		
	    Map<String, String> errors = new HashMap<>();
	    
	     ex.getBindingResult().getFieldErrors().forEach(error -> 
	        errors.put(error.getField(), error.getDefaultMessage())
	    );

	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}

	
}
