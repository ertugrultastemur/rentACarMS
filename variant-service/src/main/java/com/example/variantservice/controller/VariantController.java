package com.example.variantservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.variantservice.dto.request.CreateVariantRequestDto;
import com.example.variantservice.dto.request.UpdateVariantRequestDto;
import com.example.variantservice.dto.response.GetAllVariantsResponseDto;
import com.example.variantservice.dto.response.GetByIdVariantDto;
import com.example.variantservice.service.VariantService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@RestController
@RequestMapping("/v1/variant")
@Validated
public class VariantController {
	
	private final VariantService variantService;
	
	@GetMapping("/variant/getAll")
	public List<GetAllVariantsResponseDto> getAll() {
		return variantService.getAll();
	}
	
	@GetMapping("/variant/getById/{id}")
	public GetByIdVariantDto getById(@PathVariable(name = "id") int id) {
		return variantService.getById(id);
	}
	
	@PostMapping("/variant/add/{variant}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateVariantRequestDto variant) {
		variantService.add(variant);
	}
	
	@PutMapping("/variant/update/{variant}")
	public void update(@RequestBody @Valid @NotNull UpdateVariantRequestDto variant) {
		variantService.update(variant);
	}
	
	@DeleteMapping("/variant/delete/{id}")
	public void delete(@PathVariable @Valid @NotNull int id) {
		variantService.delete(id);
	}
	
	
	
}
