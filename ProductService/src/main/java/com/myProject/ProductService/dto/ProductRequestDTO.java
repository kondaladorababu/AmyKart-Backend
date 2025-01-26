package com.myProject.ProductService.dto;

public class ProductRequestDTO {
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;

    // Optional fields for filtering
    private String brand;
    private String size;
    private String color;
    private String material;
    private String fit;
    private String occasion;
    private String neck;
    private String author;
    private String genre;
    private String language;
    private String type;
    private Double rating;
    private Double discount;

    public ProductRequestDTO() {
    }

    public ProductRequestDTO(String title, Double price, String description, String image, String category, String brand, String size, String color, String material, String fit, String occasion, String neck, String author, String genre, String language, String type, Double rating, Double discount) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
        this.brand = brand;
        this.size = size;
        this.color = color;
        this.material = material;
        this.fit = fit;
        this.occasion = occasion;
        this.neck = neck;
        this.author = author;
        this.genre = genre;
        this.language = language;
        this.type = type;
        this.rating = rating;
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
