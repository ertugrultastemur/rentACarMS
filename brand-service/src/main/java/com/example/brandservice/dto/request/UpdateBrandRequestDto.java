package com.example.brandservice.dto.request;

import com.example.brandservice.model.Brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequestDto {

	@NotNull
	@NotBlank
	private int id;
	
	@NotNull
	@NotBlank
	private String name;
	
	public static UpdateBrandRequestDto convert(Brand brand) {
		return new UpdateBrandRequestDto(
				brand.getId(),
				brand.getName()
				);
		
	}
}
