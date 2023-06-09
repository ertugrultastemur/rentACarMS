package com.example.carservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.example.carservice.dto.request.CreateCarRequestDto;
import com.example.carservice.dto.request.UpdateCarRequestDto;
import com.example.carservice.dto.response.GetAllCarsResponse;
import com.example.carservice.dto.response.GetCarDto;
import com.example.carservice.dto.response.GetCarIdDto;
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
	
	Logger logger = LoggerFactory.getLogger(CarController.class);
	
	@GetMapping("/car/getAll")
	public List<GetAllCarsResponse> getAllCars(){
		return carService.getAllCars();
	}
	
	@PutMapping("/car/{car}")
	public void update(@RequestBody @Valid @NotNull UpdateCarRequestDto car){
		carService.update(car);
	}
	
	@GetMapping("/plate/{plate}")
	public ResponseEntity<GetCarIdDto> getCarByPlate(@PathVariable String plate){
		logger.info("Car requested by plate: " +plate);
		return ResponseEntity.ok(carService.findByPlate(plate));
	}
	
	@GetMapping("/car/{id}")
	public ResponseEntity<GetCarDto> getCarById(@PathVariable int id){
		return ResponseEntity.ok(carService.findById(id));
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateCarRequestDto carDto) {
		this.carService.add(carDto);

	}
	
	@DeleteMapping("/car/{plate}")
	public void delete(@PathVariable("plate") String plate){
		carService.delete(plate);
	}
	 
}
