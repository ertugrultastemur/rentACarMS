package com.example.carservice.dto.response;

import com.example.carservice.dto.CarIdDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarDto {
	
	private int id;
	
	private String plate;
	
	public CarIdDto convert(int id, int plate) {
		return new CarIdDto(id,plate);
	}

}
