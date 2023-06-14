package com.example.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.carservice.model.Car;


public interface CarRepository extends JpaRepository<Car, Integer>{

	java.util.Optional<Car> findByPlate(String plate);
	
	void deleteByPlate(String plate);
}
