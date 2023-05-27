package com.example.carservice.dto;

import com.example.carservice.model.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
	
	private int id;
	
	private String plate;
	
	private double dailyPrice;
	
	private int modelYear;
	
	private int state; //1 available 2 rented 3 maintanced
	
	
	public static CarDto convert(Car car) {
		return new CarDto(
				car.getId(),
				car.getPlate(),
				car.getDailyPrice(),
				car.getModelYear(),
				car.getState()
				);
		
	}
	
	
}
