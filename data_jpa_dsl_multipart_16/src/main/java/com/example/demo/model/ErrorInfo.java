package com.example.demo.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorInfo {

	private LocalDateTime timestamp;
	private String errorMessage;
	private String requestPath;
	
}
