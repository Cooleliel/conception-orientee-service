package com.ibam.users_service.ports.repositories;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibam.users_service.adapters.dtos.user.ProductResponse;

@FeignClient(name = "products-service", url = "http://localhost:8082/api/products")
public interface ProductClient {
    @GetMapping("/users")
    List<ProductResponse> getProductsByVendorId(@RequestParam("vendorId") Long vendorId);
}
