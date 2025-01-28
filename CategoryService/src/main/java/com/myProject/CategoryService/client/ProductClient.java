package com.myProject.CategoryService.client;

import com.myProject.CategoryService.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Product-Service", path = "/product")
public interface ProductClient {

    @GetMapping("/{category}")
    List<ProductDTO> getProductsByCategoryName(@PathVariable String category);
}
