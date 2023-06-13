package com.example.modelservice.dto.request;

import com.example.modelservice.model.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteModelRequestDto {

	@NotNull
	@NotBlank
	private int id;
	

	public DeleteModelRequestDto convert(Model model) {
		return new DeleteModelRequestDto(
				model.getId()
				);
	}
}
