package com.myProject.ProductService.service;

import com.myProject.ProductService.dto.ProductRequestDTO;
import com.myProject.ProductService.dto.ProductResponseDTO;
import com.myProject.ProductService.model.Product;
import com.myProject.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String addProduct(ProductRequestDTO productRequest) {
        Product product = new Product();
        product.setTitle(productRequest.getTitle());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        product.setImage(productRequest.getImage());
        product.setCategory(productRequest.getCategory());
        productRepository.save(product);
        return "Product added successfully";
    }

    @Override
    public String updateProduct(int productId, ProductRequestDTO productRequest) {
        Product product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            product.setTitle(productRequest.getTitle());
            product.setPrice(productRequest.getPrice());
            product.setDescription(productRequest.getDescription());
            product.setImage(productRequest.getImage());
            product.setCategory(productRequest.getCategory());
            productRepository.save(product);
            return "Product updated successfully";
        }
        return "Product not found";
    }

    @Override
    public List<ProductResponseDTO> getProductsByCategory(String category) {
        List<Product> products = productRepository.findByCategory(category);
        return products.stream().map(product -> {
            ProductResponseDTO responseDTO = new ProductResponseDTO();
            responseDTO.setId(product.getId());
            responseDTO.setTitle(product.getTitle());
            responseDTO.setPrice(product.getPrice());
            responseDTO.setDescription(product.getDescription());
            responseDTO.setImage(product.getImage());
            responseDTO.setRating(product.getRating());
            responseDTO.setCategory(product.getCategory());
            return responseDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public String deleteProduct(int productId) {
        Product product = productRepository.findById(productId).get();
        productRepository.delete(product);
        return "Product deleted successfully";
    }
}
