package com.example.carservice.exception;

public class CarNotFoundException extends RuntimeException{

	
	public CarNotFoundException(String e) {
		super(e);
	}
}
