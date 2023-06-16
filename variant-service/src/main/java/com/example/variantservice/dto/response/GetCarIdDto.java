package com.example.variantservice.dto.response;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCarIdDto {
	
	private int id;
	
	private String plate;
	

	public GetCarIdDto convert(int id, String plate) {
		return new GetCarIdDto(
				id,
				plate
				);
	}

}
