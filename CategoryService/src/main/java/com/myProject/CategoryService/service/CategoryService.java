package com.myProject.CategoryService.service;

import com.myProject.CategoryService.dto.CategoryRequestDTO;
import com.myProject.CategoryService.dto.CategoryResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    public String addCategory(CategoryRequestDTO category);

    public String updateCategory(String categroy, CategoryRequestDTO newCategory);

    public String deleteCategory(String category);

    public List<CategoryResponseDTO> getAllCategories();

}
