package com.example.brandservice.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.brandservice.model.Brand;
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	
	Optional<Brand> findById(int id);
	
}
