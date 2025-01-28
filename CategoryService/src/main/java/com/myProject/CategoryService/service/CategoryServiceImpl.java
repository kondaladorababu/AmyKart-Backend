package com.myProject.CategoryService.service;

import com.myProject.CategoryService.client.ProductClient;
import com.myProject.CategoryService.dto.CategoryRequestDTO;
import com.myProject.CategoryService.dto.CategoryResponseDTO;
import com.myProject.CategoryService.dto.ProductDTO;
import com.myProject.CategoryService.model.Category;
import com.myProject.CategoryService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public String addCategory(CategoryRequestDTO category) {
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());
        newCategory.setImage(category.getImage());

        categoryRepository.save(newCategory);
        return "Category added successfully!";
    }

    @Override
    public String updateCategory(String category, CategoryRequestDTO newCategory) {
        if (newCategory.getName() == null || newCategory.getDescription() == null || newCategory.getImage() == null) {
            return "Please enter all the details";
        }

        Category oldCategory = categoryRepository.findByName(category);
        if (oldCategory != null) {
            oldCategory.setName(newCategory.getName());
            oldCategory.setDescription(newCategory.getDescription());
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

    @Override
    public List<ProductDTO> getProductsBasedOnCategory(String category) {
        List<ProductDTO> products = productClient.getProductsByCategoryName(category);
        return products;
    }
}
