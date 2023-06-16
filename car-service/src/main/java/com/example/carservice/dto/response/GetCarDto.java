package com.example.carservice.dto.response;


import com.example.carservice.model.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarDto {

	private GetCarIdDto id =null;
	
	private double dailyPrice;
	
	private int modelYear;
	
	private int state; //1 available 2 rented 3 maintanced
	

	public static GetCarDto convert(Car car) {
		GetCarIdDto carIdDto = null;
	    if (car.getId()!= 0) {
	        carIdDto = GetCarIdDto.convert(car.getId(), car.getPlate());
	    }
	    return new GetCarDto(
	            carIdDto,
	            car.getDailyPrice(),
	            car.getModelYear(),
	            car.getState()
	    );
	}
}
