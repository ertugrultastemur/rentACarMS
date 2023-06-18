package com.example.variantservice.dto.request;


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
	private int id;
	
	@NotNull
	@NotBlank
	private String plate;
	

	

}
