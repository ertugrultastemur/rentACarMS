package com.example.variantservice.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

	@ExceptionHandler(VariantNotFoundException.class)
	public ResponseEntity<?> handle(VariantNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(), org.springframework.http.HttpStatus.NOT_FOUND);
	}
}
