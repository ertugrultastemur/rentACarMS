package com.example.carservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.carservice.dto.CarDto;
import com.example.carservice.dto.CarIdDto;
import com.example.carservice.dto.request.CreateCarRequestDto;
import com.example.carservice.dto.request.DeleteCarRequestDto;
import com.example.carservice.model.Car;
import com.example.carservice.service.CarService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@RestController
@RequestMapping("/v1/car")
@Validated
public class CarController {

	private final CarService carService;
	
	@GetMapping
	public ResponseEntity<List<CarDto>> getAllCars(){
		return ResponseEntity.ok(carService.getAllCars());
	}
	
	@GetMapping("/state/{state}")
	public ResponseEntity<CarIdDto> getCarByState(@PathVariable @NotNull String plate){
		return ResponseEntity.ok(carService.findByPlate(plate));
	}
	
	@GetMapping("/car/{id}")
	public ResponseEntity<CarDto> getCarById(@PathVariable @NotNull int id){
		return ResponseEntity.ok(carService.findCarById(id));
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateCarRequestDto carDto) {
		this.carService.add(carDto);
	}
	
	@DeleteMapping(name="/delete{plate}")
	public void delete(@PathVariable("plate") DeleteCarRequestDto carDto){
		carService.delete(carDto.getPlate());
	}
	
}
