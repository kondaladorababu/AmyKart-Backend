package com.myProject.ProductService.Controller;

import com.myProject.ProductService.dto.ProductRequestDTO;
import com.myProject.ProductService.dto.ProductResponseDTO;
import com.myProject.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody ProductRequestDTO productRequest) {
        String response = productService.addProduct(productRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable int productId, @RequestBody ProductRequestDTO productRequest) {
        String response = productService.updateProduct(productId, productRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByCategory(@PathVariable String category) {
        List<ProductResponseDTO> products= productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
        String response = productService.deleteProduct(productId);
        return ResponseEntity.ok(response);
    }

}
