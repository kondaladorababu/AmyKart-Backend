package com.myProject.ReviewService.model;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    int rating;
    String comment;

    @Column(name = "user_id")
    int userId;

    String username;

    @Column(name = "product_id")
    int productId;

    public Review() {
    }

    public Review(int rating, String comment, int userId, int productId) {
        this.rating = rating;
        this.comment = comment;
        this.userId = userId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
