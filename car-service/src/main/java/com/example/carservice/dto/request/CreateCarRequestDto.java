package com.example.carservice.dto.request;


import com.example.carservice.model.Car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequestDto {
	
	@NotNull
	@NotBlank
	private String plate;
	
	@NotNull
	private double DailyPrice;
	
	@NotNull
	private int modelYear;
	
	@NotNull
	private int state;
	
	@NotNull
	private int modelId;
	
	public static CreateCarRequestDto convert(Car car) {
		return new CreateCarRequestDto(
				car.getPlate(),
				car.getDailyPrice(),
				car.getModelId(),
				car.getState(),
				car.getModelYear()
				
				);
		
	}
}
