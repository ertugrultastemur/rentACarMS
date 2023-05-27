package com.example.carservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarIdDto {

	private int id;
	
	private int plate;
	
	public CarIdDto convert(int id, int plate) {
		return new CarIdDto(id,plate);
	}

}
