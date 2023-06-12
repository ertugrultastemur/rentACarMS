package com.example.carservice.dto.response;

import com.example.carservice.dto.CarIdDto;
import com.example.carservice.model.Car;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarByPlateDto {
	
	private int id;
	
	private String plate;
	
	private double dailyPrice;

	private int modelYear;

	private int state;
	
	public GetCarByPlateDto convert(Car car) {
		return new GetCarByPlateDto(
				car.getId(),
				car.getPlate(),
				car.getDailyPrice(),
				car.getModelYear(),
				car.getState()
				);
	}

}
