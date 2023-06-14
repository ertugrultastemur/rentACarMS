package com.example.brandservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="brand-service", path = "/v1/brand")
public interface BrandServiceClient {

}
