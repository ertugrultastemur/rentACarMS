package com.example.variantservice.dto.response;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarByIdDto {

	private int id;
	
	private String plate;
	
	private double dailyPrice;

	private int modelYear;

	private int state;
}
