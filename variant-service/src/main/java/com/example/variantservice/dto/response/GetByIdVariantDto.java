package com.example.variantservice.dto.response;


import com.example.variantservice.model.Variant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdVariantDto {

	@NotNull
	private int id;
	
	@NotNull
	@NotBlank
	private String name;
	
	public GetByIdVariantDto convert(Variant variant) {
		return new GetByIdVariantDto(
				variant.getId(),
				variant.getName()
				);
	}
}