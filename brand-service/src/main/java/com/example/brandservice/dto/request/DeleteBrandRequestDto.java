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
public class DeleteBrandRequestDto {

	@NotNull
	@NotBlank
	private int  id;
	
	public static DeleteBrandRequestDto convert(Brand brand) {
		return new DeleteBrandRequestDto(
				brand.getId()
				);
		
	}
}
