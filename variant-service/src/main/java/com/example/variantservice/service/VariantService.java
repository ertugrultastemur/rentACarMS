package com.example.variantservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.variantservice.dto.request.CreateVariantRequestDto;
import com.example.variantservice.dto.request.UpdateVariantRequestDto;
import com.example.variantservice.dto.response.GetAllVariantsResponseDto;
import com.example.variantservice.dto.response.GetByIdVariantDto;
import com.example.variantservice.exception.VariantNotFoundException;
import com.example.variantservice.model.Variant;
import com.example.variantservice.repository.VariantRepository;
import com.example.variantservice.util.ModelMapperService;

import jakarta.transaction.Transactional;

@Service
public class VariantService {

	private final VariantRepository repository;
	
	private ModelMapperService modelMapperService;
	
	public VariantService(VariantRepository repository, ModelMapperService modelMapperService) {
		this.repository = repository;
		this.modelMapperService = modelMapperService;
	}
	
	public List<GetAllVariantsResponseDto> getAll(){
		return repository
				.findAll()
				.stream()
				.map(variant -> this.modelMapperService.forResponse().map(variant, GetAllVariantsResponseDto.class))
				.collect(Collectors.toList());
	}
	
	public GetByIdVariantDto getById(int id) {
		return repository.findById(id).map(variant -> this.modelMapperService.forResponse().map(variant, GetByIdVariantDto.class)).get();
	}
	
	public void add(CreateVariantRequestDto variantDto) {
		Variant variant = this.modelMapperService.forRequest().map(variantDto, Variant.class);
		repository.save(variant);
	}
	
	public void update(UpdateVariantRequestDto variantDto) {
		Variant variant = this.modelMapperService.forRequest().map(variantDto, Variant.class);
		repository.findById(variantDto.getId()).map(newVariant -> variant).orElseThrow(() -> new VariantNotFoundException("Model not found by id: " + variantDto.getId()));
		repository.save(variant);
	}
	
	@Transactional
	public void delete(int id) {
		Variant variant = repository
				.findById(id)
				.orElseThrow(() -> new VariantNotFoundException("Entity not found by id:" + id));
		variant.setDeleted(true);
		repository.save(variant);
	}
	
}
