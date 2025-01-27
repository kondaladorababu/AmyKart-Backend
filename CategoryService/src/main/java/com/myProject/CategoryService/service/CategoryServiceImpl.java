package com.myProject.CategoryService.service;

import com.myProject.CategoryService.dto.CategoryRequestDTO;
import com.myProject.CategoryService.dto.CategoryResponseDTO;
import com.myProject.CategoryService.model.Category;
import com.myProject.CategoryService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public String addCategory(CategoryRequestDTO category) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setImage(category.getImage());

        categoryRepository.save(newCategory);
        return "Category added successfully!";
    }

    @Override
    public String updateCategory(String category, CategoryRequestDTO newCategory) {
        Category oldCategory = categoryRepository.findByName(category);
        if (oldCategory != null) {
            oldCategory.setName(newCategory.getName());
            oldCategory.setImage(newCategory.getImage());
            categoryRepository.save(oldCategory);
            return "Category updated successfully!";
        }
        return "Category not found!";
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryResponseDTO> categoryResponseDTOS = categories.stream().map(category ->
        {
            CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
            categoryResponseDTO.setCategoryId(category.getId());
            categoryResponseDTO.setName(category.getName());
            categoryResponseDTO.setDescription(category.getDescription());
            categoryResponseDTO.setImage(category.getImage());
            return categoryResponseDTO;
        }).toList();
        return categoryResponseDTOS;
    }

    @Override
    public String deleteCategory(String category) {
        Category oldCategory = categoryRepository.findByName(category);
        if (oldCategory != null) {
            categoryRepository.delete(oldCategory);
            return "Category deleted successfully!";
        }
        return "Category not found!";
    }
}
