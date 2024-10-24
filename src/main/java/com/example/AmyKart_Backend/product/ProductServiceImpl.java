package com.example.AmyKart_Backend.product;

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

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
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
            product.setId(id);
            productRepository.save(product);
            return true;
        }
        return false;
    }
}
