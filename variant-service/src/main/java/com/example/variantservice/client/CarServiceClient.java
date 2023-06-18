package com.example.variantservice.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.variantservice.dto.response.GetCarDto;
import com.example.variantservice.dto.response.GetCarIdDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name= "car-service", path = "/v1/car")
public interface CarServiceClient {

		Logger logger = LoggerFactory.getLogger(CarServiceClient.class);
	
		@GetMapping("/plate/{plate}")
		@CircuitBreaker(name="getCarByPlateCircuitBreaker", fallbackMethod = "getCarByPlateFallBack")
		public ResponseEntity<GetCarIdDto> getCarByPlate(@PathVariable("plate") String plate);
		
		default ResponseEntity<GetCarIdDto> getCarFallBack(String plate, Exception exception){
			logger.info("Car not found by plate" + plate + ", returning default GetCarIdDto object.");
			return ResponseEntity.ok(new GetCarIdDto(99, "default-plate"));
		}
		
		
		@GetMapping("/car/{id}")
		@CircuitBreaker(name="getCarByIdCircuitBreaker", fallbackMethod = "getCarByIdFallBack")
		public ResponseEntity<GetCarDto> getCarById(@PathVariable("id") int id);
		
		default ResponseEntity<GetCarDto> getCarByIdFallBack(int id, Exception exception){
			logger.info("Car not found by id" + id + ", returning default GetCarDto object.");
			return ResponseEntity.ok(new GetCarDto(new GetCarIdDto(99, "default-plate")));
		}
		
//		@PostMapping
//		@ResponseStatus(code = HttpStatus.CREATED)
//		public void add(@RequestBody CreateCarRequestDto carDto);
//
}
