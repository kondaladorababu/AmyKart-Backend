package com.myProject.ProductService.Controller;

import com.myProject.ProductService.dto.ProductDetailsDTO;
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
        List<ProductResponseDTO> products = productService.getProductsByCategory(category);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/filter/{category}")
    public ResponseEntity<List<ProductResponseDTO>> getProductsByFilters(
            @PathVariable String category,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) List<String> brands,
            @RequestParam(required = false) List<String> sizes,
            @RequestParam(required = false) List<String> colors,
            @RequestParam(required = false) List<String> materials,
            @RequestParam(required = false) List<String> fits,
            @RequestParam(required = false) List<String> occasions,
            @RequestParam(required = false) List<String> necks,
            @RequestParam(required = false) List<String> authors,
            @RequestParam(required = false) List<String> genres,
            @RequestParam(required = false) List<String> languages,
            @RequestParam(required = false) List<String> types,
            @RequestParam(required = false) Double minRating,
            @RequestParam(required = false) Double minDiscount) {
        List<ProductResponseDTO> products = productService.getProductsByFilters(
                category, minPrice, maxPrice, brands, sizes, colors, materials,
                fits, occasions, necks, authors, genres, languages, types, minRating,
                minDiscount);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int productId) {
        String response = productService.deleteProduct(productId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/details/{productId}")
    public ResponseEntity<ProductDetailsDTO> getProductDetails(@PathVariable int productId) {
        ProductDetailsDTO productDetails = productService.getProductDetails(productId);
        return ResponseEntity.ok(productDetails);
    }

}
