package com.example.AmyKart_Backend.product;

import com.example.AmyKart_Backend.review.Review;

import java.util.List;

public class ProductResponse {

    private final int id;
    private final String title;
    private final double price;
    private final String description;
    private final String category;
    private final String imageUrl;
    private final List<Review> reviews;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.description = product.getDescription();
        this.category = product.getCategory();
        this.imageUrl = "/products/image/" + product.getId();
        this.reviews = product.getReview();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getImage() {
        return imageUrl;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
