package com.myProject.ProductService.service;

import com.myProject.ProductService.dto.ProductRequestDTO;
import com.myProject.ProductService.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    public String addProduct(ProductRequestDTO productRequest);

    public String updateProduct(int productId, ProductRequestDTO productRequest);

    public List<ProductResponseDTO> getProductsByCategory(String category);

    public List<ProductResponseDTO> getProductsByFilters(String category, Double minPrice, Double maxPrice, List<String> brands, Double minRating);

    public String deleteProduct(int productId);
}
