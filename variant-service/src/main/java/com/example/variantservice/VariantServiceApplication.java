package com.example.variantservice;


import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.variantservice.client.RetreiveMessageErrorDecoder;

import feign.Logger;

import feign.codec.ErrorDecoder;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.example.variantservice.client")
public class VariantServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(VariantServiceApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
//	@Bean
//	public ErrorDecoder errorDecoder() {
//		return new RetreiveMessageErrorDecoder();
//	}
//	
//	@Bean
//	Logger.Level feignLoggerLevel(){
//		return Logger.Level.FULL;
//	}
	


}
