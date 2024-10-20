package com.example.AmyKart_Backend.service.impl;

import com.example.AmyKart_Backend.entity.Product;
import com.example.AmyKart_Backend.repository.ProductRepository;
import com.example.AmyKart_Backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean updateProduct(Integer id, Product product) {
        Optional<Product> theProduct = productRepository.findById(id);
        if (theProduct.isPresent()) {
            Product updatedProduct = theProduct.get();
            updatedProduct.setTitle(product.getTitle());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setCategory(product.getCategory());
            updatedProduct.setImage(product.getImage());
            updatedProduct.setRating(product.getRating());
            productRepository.save(updatedProduct);
            return true;
        }
        return false;
    }
}
