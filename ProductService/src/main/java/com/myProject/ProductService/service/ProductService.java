package com.myProject.ProductService.service;

import com.myProject.ProductService.dto.ProductDetailsDTO;
import com.myProject.ProductService.dto.ProductRequestDTO;
import com.myProject.ProductService.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {

    public String addProduct(ProductRequestDTO productRequest);

    public String updateProduct(int productId, ProductRequestDTO productRequest);

    public List<ProductResponseDTO> getProductsByCategory(String category);

    public List<ProductResponseDTO> getProductsByFilters(
            String category, Double minPrice, Double maxPrice, List<String> brands, List<String> sizes,
            List<String> colors, List<String> materials, List<String> fits, List<String> occasions,
            List<String> necks, List<String> authors, List<String> genres, List<String> languages,
            List<String> types, Double minRating, Double minDiscount);

    public String deleteProduct(int productId);

    public ProductDetailsDTO getProductDetails(int productId);
}
