package com.example.brandservice.dto.response;

import com.example.brandservice.model.Brand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {

	@NotBlank
	@NotNull
	private int id;
	
	@NotNull
	private String name;
	
	public static GetAllBrandsResponse convert(Brand brand) {
		return new GetAllBrandsResponse(
				brand.getId(),
				brand.getName()
				);
		
	}
}
