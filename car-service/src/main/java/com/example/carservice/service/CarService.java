package com.example.carservice.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.carservice.dto.CarDto;
import com.example.carservice.dto.CarIdDto;
import com.example.carservice.dto.request.CreateCarRequestDto;
import com.example.carservice.dto.request.DeleteCarRequestDto;
import com.example.carservice.exception.CarNotFoundException;
import com.example.carservice.model.Car;
import com.example.carservice.repository.CarRepository;
import com.example.carservice.util.ModelMapperService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
public class CarService {
	
	private final CarRepository repository;
	
	private ModelMapperService modelMapperService;
	
	public CarService(CarRepository repository,ModelMapperService modelMapperService) {
		this.repository = repository;
		this.modelMapperService = modelMapperService;
	}
	
	public List<CarDto> getAllCars(){
		return repository.findAll()
				.stream()
				.map(carDto -> CarDto.convert(carDto))
				.collect(Collectors.toList())
				;
	}
	
	public CarIdDto findByPlate(String plate) {
		return repository.findByPlate(plate)
				.map(car -> new CarIdDto(car.getId(),car.getState()))
				.orElseThrow(() -> new CarNotFoundException("Car could not found by plate : " + plate));
	}
	
	public CarDto findCarById(int id) {
		return repository.findById(id)
				.map(carDto -> CarDto.convert(carDto)).orElseThrow(() -> new CarNotFoundException("Car could not found by id : " + id));
	}
	
	public void add(CreateCarRequestDto carDto) {
		Car car = modelMapperService.forRequest().map(carDto, Car.class);
		this.repository.save(car);
	}
	
	public void delete(String plate) {
		//Car car = modelMapperService.forRequest().map(carDto, Car.class);
		this.repository.deleteByPlate(plate);
	}

}
