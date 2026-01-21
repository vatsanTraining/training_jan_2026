package com.example.demo.utils;

import java.io.IOException;
import java.time.LocalDateTime;

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
	
	
	
}
