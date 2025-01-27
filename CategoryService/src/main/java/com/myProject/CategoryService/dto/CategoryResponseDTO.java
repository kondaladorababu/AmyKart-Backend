package com.myProject.CategoryService.dto;

public class CategoryResponseDTO {
    private int categoryId;
    private String name;
    private String description;
    private String image;

    public CategoryResponseDTO() {
    }

    public CategoryResponseDTO(int categoryId, String name, String description, String image) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
