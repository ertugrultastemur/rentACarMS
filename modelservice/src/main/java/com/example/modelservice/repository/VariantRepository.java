package com.example.modelservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelservice.model.Model;

public interface VariantRepository extends JpaRepository<Model, Integer>{

	Optional<Model> findById(int id);
}
