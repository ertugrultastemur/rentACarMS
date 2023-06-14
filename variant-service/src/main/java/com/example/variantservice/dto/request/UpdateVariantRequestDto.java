package com.example.variantservice.dto.request;


import com.example.variantservice.model.Variant;

import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateVariantRequestDto {

	@NotNull
	private int id;
	
	@NotNull
	@NotBlank
	private String name;
	
	public UpdateVariantRequestDto convert(Variant variant) {
		return new UpdateVariantRequestDto(
				variant.getId(),
				variant.getName()
				);
	}
}
