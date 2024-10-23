package com.example.AmyKart_Backend.product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void createProduct(Product product);

    Product getProductById(Integer id);

    void deleteProduct(Integer id);

    boolean updateProduct(Integer id, Product product);
}
