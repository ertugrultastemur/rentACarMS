package com.example.modelservice.dto.request;

import com.example.modelservice.model.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateModelRequestDto {


	@NotNull
	@NotBlank
	private String name;
	
	public CreateModelRequestDto convert(Model model){
		return new CreateModelRequestDto(
			model.getName()
		);
	}
}
