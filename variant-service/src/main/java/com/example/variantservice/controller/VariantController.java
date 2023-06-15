package com.example.variantservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.example.variantservice.dto.request.CreateCarRequestDto;
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
	
	
	public VariantController(VariantService variantService) {
		this.variantService = variantService;

	}
	
	@GetMapping("/variant/getAll")
	public List<GetAllVariantsResponseDto> getAll() {
		return variantService.getAll();
	}
	
	@GetMapping("/variant/{id}")
	public GetByIdVariantDto getById(@PathVariable(name = "id") int id) {
		return variantService.getById(id);
	}
	
	@GetMapping("/car/{id}")
	public ResponseEntity<GetByIdVariantDto> getAllCarsInVariantById(@PathVariable int id){
		return ResponseEntity.ok(variantService.getAllCarsInVariantById(id));
	}
	
	@PostMapping("/variant/{variant}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateVariantRequestDto variant) {
		variantService.add(variant);
	}
	
	@PutMapping("/variant/{variant}")
	public void update(@RequestBody @Valid @NotNull UpdateVariantRequestDto variant) {
		variantService.update(variant);
	}
	
	@PutMapping
	public ResponseEntity<Void> addCarToVariant(@RequestBody CreateCarRequestDto carDto){
		variantService.addCarToVariant(carDto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/variant/{id}")
	public void delete(@PathVariable @Valid @NotNull int id) {
		variantService.delete(id);
	}
	
	
	
}
