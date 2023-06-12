package com.example.carservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.carservice.dto.request.CreateCarRequestDto;
import com.example.carservice.dto.request.UpdateCarRequestDto;
import com.example.carservice.dto.response.GetAllCarsResponse;
import com.example.carservice.dto.response.GetCarByPlateDto;
import com.example.carservice.exception.CarNotFoundException;
import com.example.carservice.model.Car;
import com.example.carservice.repository.CarRepository;
import com.example.carservice.util.ModelMapperService;

import jakarta.transaction.Transactional;

@Service
public class CarService {
	
	private final CarRepository repository;
	
	private ModelMapperService modelMapperService;
	
	public CarService(CarRepository repository,ModelMapperService modelMapperService) {
		this.repository = repository;
		this.modelMapperService = modelMapperService;
	}
	
	public List<GetAllCarsResponse> getAllCars(){
		return repository.findAll()
				.stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class) )
				.collect(Collectors.toList())
				;
	}
	
	public GetCarByPlateDto findByPlate(String plate) {
		return repository.findByPlate(plate)
				.map(car -> new GetCarByPlateDto(car.getId(),car.getPlate(), car.getDailyPrice(),car.getModelYear(), car.getState()))
				.orElseThrow(() -> new CarNotFoundException("Car could not found by plate : " + plate));
	}
	
	public void add(CreateCarRequestDto carDto) {
		Car car = modelMapperService.forRequest().map(carDto, Car.class);
		this.repository.save(car);
	}
	
	@Transactional
	public void delete(String plate) {
		Car car = repository
				.findByPlate(plate)
	            .orElseThrow(() -> new CarNotFoundException("Entity not found"));
		car.setDeleted(true);
		this.repository.save(car);
	}
	
	public void update(UpdateCarRequestDto carDto) {
		Car car = modelMapperService.forRequest().map(carDto, Car.class);
		repository
				.findByPlate(carDto.getPlate()).map(carD -> {
					car.setId(carD.getId());
					return carD;
				}).orElseThrow(() -> new CarNotFoundException("Car could not found by plate : " + car.getPlate()));
	this.repository.save(car);
		
	}
//	@Transactional
//	public void deletes(DeleteCarRequestDto carDto) {
//		repository.findAll()
//		.stream()
//		.filter(car -> car.getPlate().equals(carDto.getPlate())).map(car -> {
//            car.setDeleted(true);
//    		  repository.save(car);
//            return car;
//        });
//	}

}
