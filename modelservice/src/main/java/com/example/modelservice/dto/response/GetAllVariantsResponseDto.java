package com.example.modelservice.dto.response;

import com.example.modelservice.model.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetAllVariantsResponseDto {

	@NotNull
	@NotBlank
	private int id;
	
	@NotNull
	@NotBlank
	private String name;
	
	public GetAllVariantsResponseDto convert(Model model) {
		return new GetAllVariantsResponseDto(
				model.getId(),
				model.getName()
				);
	}
}
