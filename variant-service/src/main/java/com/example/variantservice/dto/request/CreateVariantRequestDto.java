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
public class CreateVariantRequestDto {


	@NotNull
	@NotBlank
	private String name;
	
	public CreateVariantRequestDto convert(Variant variant){
		return new CreateVariantRequestDto(
			variant.getName()
		);
	}
}

