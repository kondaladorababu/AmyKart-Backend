package com.myProject.CategoryService.controller;

import com.myProject.CategoryService.dto.CategoryRequestDTO;
import com.myProject.CategoryService.dto.CategoryResponseDTO;
import com.myProject.CategoryService.dto.ProductDTO;
import com.myProject.CategoryService.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Add your code here
    @PostMapping
    public ResponseEntity<String> addCategory(CategoryRequestDTO category) {
        String response =  categoryService.addCategory(category);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{category}")
    public ResponseEntity<String> updateCategory(@PathVariable String category, CategoryRequestDTO newCategory) {
        String response = categoryService.updateCategory(category, newCategory);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        List<CategoryResponseDTO> categoryResponseDTOS = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryResponseDTOS);
    }

    @DeleteMapping("/{category}")
    public String deleteCategory(@PathVariable String category) {
        return categoryService.deleteCategory(category);
    }

    @GetMapping("/{category}/products")
    public ResponseEntity<List<ProductDTO>> getProductsBasedOnCategory(@PathVariable String category) {
        List<ProductDTO> products = categoryService.getProductsBasedOnCategory(category);
        return ResponseEntity.ok(products);
    }

}
