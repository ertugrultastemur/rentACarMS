package com.example.variantservice.dto.response;


import java.util.ArrayList;
import java.util.List;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdVariantDto {

	@NotNull
	private int id;
	
	private List<GetCarDto> userCar = new ArrayList<>();
	
	
	








}