package com.example.variantservice.dto.response;



import com.example.variantservice.model.Variant;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllVariantsResponseDto {

	@NotNull
	private int id;
	
	@NotNull
	@NotBlank
	private String name;
	
	public GetAllVariantsResponseDto convert(Variant variant) {
		return new GetAllVariantsResponseDto(
				variant.getId(),
				variant.getName()
				);
	}
}
