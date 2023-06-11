package com.example.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carservice.dto.request.DeleteCarRequestDto;
import com.example.carservice.model.Car;
import com.google.common.base.Optional;

public interface CarRepository extends JpaRepository<Car, Integer>{

	java.util.Optional<Car> findByPlate(String plate);
	
	void deleteByPlate(String plate);
}
