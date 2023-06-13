package com.example.variantservice.dto.request;


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
public class DeleteVariantRequestDto {

	@NotNull
	private int id;
	

	public DeleteVariantRequestDto convert(Variant variant) {
		return new DeleteVariantRequestDto(
				variant.getId()
				);
	}
}
