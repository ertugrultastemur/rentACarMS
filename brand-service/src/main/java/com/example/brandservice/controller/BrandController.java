package com.example.brandservice.controller;

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

import com.example.brandservice.dto.request.CreateBrandRequestDto;
import com.example.brandservice.dto.request.UpdateBrandRequestDto;
import com.example.brandservice.dto.response.GetAllBrandsResponse;
import com.example.brandservice.service.BrandService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@RestController
@RequestMapping("/v1/brand")
@Validated
public class BrandController {
	
	private final BrandService brandService;
	
	@GetMapping("/brand/getAll")
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	@GetMapping("/brand/getById/{id}")
	public void getById(@PathVariable int id) {
		brandService.getBrandById(id);
	}
	
	@PostMapping("/brand/add/{brand}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateBrandRequestDto brand) {
		brandService.add(brand);
	}
	
	@PutMapping("/brand/update/{brand}")
	public void update(@RequestBody UpdateBrandRequestDto brand) {
		brandService.update(brand);
	}

	@DeleteMapping("/brand/delete/{id}")
	public void delete(@PathVariable @NotNull int id) {
		brandService.delete(id);
	}
}
