package com.example.variantservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.variantservice.model.Variant;

public interface VariantRepository extends JpaRepository<Variant, Integer> {

	Optional<Variant> findById(int id);
}
