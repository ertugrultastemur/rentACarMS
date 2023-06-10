package com.example.carservice.dto.request;

import com.example.carservice.dto.CarDto;
import com.example.carservice.model.Car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteCarRequestDto {

//	@NotNull
//	@NotBlank
//	private int id;
	
	@NotNull
	@NotBlank
	private String plate;
	

	public static CarDto convert(Car car) {
		return new CarDto(
				car.getModelId(),
				car.getPlate(),
				car.getDailyPrice(),
				car.getModelYear(),
				car.getState()
				);
		
	}
}
