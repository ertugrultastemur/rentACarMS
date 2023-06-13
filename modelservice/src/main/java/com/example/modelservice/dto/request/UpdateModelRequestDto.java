package com.example.modelservice.dto.request;

import com.example.modelservice.model.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateModelRequestDto {

	@NotNull
	@NotBlank
	private int id;
	
	@NotNull
	@NotBlank
	private String name;
	
	public UpdateModelRequestDto convert(Model model) {
		return new UpdateModelRequestDto(
				model.getId(),
				model.getName()
				);
	}
}
