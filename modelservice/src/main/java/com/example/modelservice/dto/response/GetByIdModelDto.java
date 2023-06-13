package com.example.modelservice.dto.response;

import com.example.modelservice.model.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetByIdModelDto {

	@NotNull
	@NotBlank
	private int id;
	
	@NotNull
	@NotBlank
	private String name;
	
	public GetByIdModelDto convert(Model model) {
		return new GetByIdModelDto(
				model.getId(),
				model.getName()
				);
	}
}
