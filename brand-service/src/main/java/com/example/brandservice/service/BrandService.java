package com.example.brandservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.brandservice.dto.request.CreateBrandRequestDto;
import com.example.brandservice.dto.request.UpdateBrandRequestDto;
import com.example.brandservice.dto.response.GetAllBrandsResponse;
import com.example.brandservice.dto.response.GetBrandByIdDto;
import com.example.brandservice.exception.BrandNotFoundException;
import com.example.brandservice.model.Brand;
import com.example.brandservice.repository.BrandRepository;
import com.example.brandservice.util.ModelMapperService;

import jakarta.transaction.Transactional;

@Service
public class BrandService {

	private final BrandRepository repository;
	
	private ModelMapperService modelMapperService;
	
	public BrandService(BrandRepository repository, ModelMapperService modelMapperService) {
		this.repository = repository;
		this.modelMapperService = modelMapperService;
	}
	
	public List<GetAllBrandsResponse> getAll() {
		return repository.findAll()
				.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand , GetAllBrandsResponse.class)).collect(Collectors.toList());
	}
	
	public GetBrandByIdDto getBrandById(int id) {
		return repository
			.findById(id)
			.map(brand -> this.modelMapperService.forResponse().map(brand , GetBrandByIdDto.class)).get();
	}
	
	public void add(CreateBrandRequestDto brandDto) {
		Brand brand = this.modelMapperService.forRequest().map(brandDto, Brand.class);
		repository.save(brand);
	}
	
	public void update(UpdateBrandRequestDto updateBrandRequestDto) {
		Brand brandDto = this.modelMapperService.forRequest().map(updateBrandRequestDto, Brand.class);
		repository.findById(updateBrandRequestDto.getId()).map(brand -> brandDto).orElseThrow(() -> new BrandNotFoundException("Brand could not found by id : " + brandDto.getId()));
		repository.save(brandDto);
	}
	
	@Transactional
	public void delete(int id) {
		Brand brand = repository
				.findById(id)
				.orElseThrow(() -> new BrandNotFoundException("Entity not found"));
		brand.setDeleted(true);
		repository.save(brand);
	}
}
