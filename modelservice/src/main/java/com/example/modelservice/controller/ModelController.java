package com.example.modelservice.controller;

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

import com.example.modelservice.dto.request.CreateModelRequestDto;
import com.example.modelservice.dto.request.UpdateModelRequestDto;
import com.example.modelservice.dto.response.GetAllVariantsResponseDto;
import com.example.modelservice.dto.response.GetByIdModelDto;
import com.example.modelservice.service.MService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@RestController
@RequestMapping("/v1/model")
@Validated
public class ModelController {
	
	private final MService mService;
	
	@GetMapping("/model/getAll")
	public List<GetAllVariantsResponseDto> getAll() {
		return this.mService.getAll();
	}
	
	@GetMapping("/model/getById/{id}")
	public GetByIdModelDto getById(@PathVariable int id) {
		return this.mService.getById(id);
	}
	
	@PostMapping("/model/add/{modelDto}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateModelRequestDto modelDto) {
		this.mService.add(modelDto);
	}
	
	@PutMapping("/model/update/{modelDto}")
	public void update(@RequestBody @Valid @NotNull UpdateModelRequestDto modelDto) {
		this.mService.update(modelDto);
	}
	
	@DeleteMapping("/model/delete/{id}")
	public void delete(@PathVariable @Valid @NotNull int id) {
		this.mService.delete(id);
	}
	
	
	
}
