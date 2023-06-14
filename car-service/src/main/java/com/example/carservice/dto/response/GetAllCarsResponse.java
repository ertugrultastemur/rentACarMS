package com.example.carservice.dto.response;

import com.example.carservice.model.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {

	private int id;

	private String plate;

	private double dailyPrice;

	private int modelYear;

	private int state;
	
	
	public static GetAllCarsResponse convert(Car car) {
		return new GetAllCarsResponse(
				car.getId(),
				car.getPlate(),
				car.getDailyPrice(),
				car.getModelYear(),
				car.getState()
				);
		
	}
	
}
