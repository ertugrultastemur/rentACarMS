package com.example.variantservice.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.variantservice.dto.request.CreateCarRequestDto;
import com.example.variantservice.dto.response.GetCarByIdDto;
import com.example.variantservice.dto.response.GetCarByPlateDto;

@FeignClient(name= "car-service", path = "/v1/car")
public interface CarServiceClient {


		@GetMapping("/plate/{plate}")
		public ResponseEntity<GetCarByPlateDto> getCarByPlate(@PathVariable String plate);
		
		@GetMapping("/car/{id}")
		public ResponseEntity<GetCarByIdDto> getCarById(@PathVariable int id);
		
		@PostMapping
		@ResponseStatus(code = HttpStatus.CREATED)
		public void add(@RequestBody CreateCarRequestDto carDto);

}
