package com.example.variantservice.dto.response;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarDto {

	private GetCarIdDto id = null;
	
	private double dailyPrice;

	private int modelYear;

	private int state;
	
	public GetCarDto(GetCarIdDto getCarIdDto) {
		this.id = getCarIdDto;
	}
}
