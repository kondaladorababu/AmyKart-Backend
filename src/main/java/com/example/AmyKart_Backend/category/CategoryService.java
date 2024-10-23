package com.example.AmyKart_Backend.category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    void createCategory(Category category);

    Category getCategoryById(Integer id);

    void deleteCategory(Integer id);

}
