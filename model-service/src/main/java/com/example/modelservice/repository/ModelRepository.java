package com.example.modelservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.modelservice.model.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{

}
