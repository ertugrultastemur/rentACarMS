package com.example.carservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.carservice.model.Car;


public interface CarRepository extends JpaRepository<Car, Integer>{

	Optional<Car> findByPlate(String plate);
	
	void deleteByPlate(String plate);
}
