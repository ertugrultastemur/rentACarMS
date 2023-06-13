package com.example.modelservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.carservice.util.ModelMapperService;
import com.example.modelservice.dto.request.CreateModelRequestDto;
import com.example.modelservice.dto.request.UpdateModelRequestDto;
import com.example.modelservice.dto.response.GetAllVariantsResponseDto;
import com.example.modelservice.dto.response.GetByIdModelDto;
import com.example.modelservice.exception.ModelNotFoundException;
import com.example.modelservice.model.Model;
import com.example.modelservice.repository.VariantRepository;

import jakarta.transaction.Transactional;

@Service
public class MService {

	private final VariantRepository repository;
	
	private ModelMapperService modelMapperService;
	
	public MService(VariantRepository repository, ModelMapperService modelMapperService) {
		this.repository = repository;
		this.modelMapperService = modelMapperService;
	}
	
	public List<GetAllVariantsResponseDto> getAll(){
		return repository
				.findAll()
				.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllVariantsResponseDto.class)).collect(Collectors.toList());
	}
	
	public GetByIdModelDto getById(int id) {
		return repository.findById(id).map(model -> this.modelMapperService.forResponse().map(model, GetByIdModelDto.class)).get();
	}
	
	public void add(CreateModelRequestDto modelDto) {
		Model model = this.modelMapperService.forRequest().map(modelDto, Model.class);
		repository.save(model);
	}
	
	public void update(UpdateModelRequestDto modelDto) {
		Model model = this.modelMapperService.forRequest().map(modelDto, Model.class);
		repository.findById(modelDto.getId()).orElseThrow(() -> new ModelNotFoundException("Model not found by id: " + modelDto.getId()));
		repository.save(model);
	}
	
	@Transactional
	public void delete(int id) {
		Model model = repository
				.findById(id)
				.orElseThrow(() -> new ModelNotFoundException("Entity not found by id:" + id));
		model.setDeleted(true);
		repository.save(model);
	}
	
}
