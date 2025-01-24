package com.myProject.ReviewService.dto;

public class ReviewRequestDTO {
    private int productId;
    private int userId;
    private int rating;
    private String reviewText;

    public ReviewRequestDTO() {
    }

    public ReviewRequestDTO(int productId, int userId, int rating, String reviewText) {
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
        this.reviewText = reviewText;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }
}
