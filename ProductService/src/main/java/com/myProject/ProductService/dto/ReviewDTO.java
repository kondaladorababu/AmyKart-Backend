package com.myProject.ProductService.dto;


public class ReviewDTO {
    private int reviewId;
    private int rating;
    private String comment;
    private int userId;
    private String userName;
    private int productId;

    public ReviewDTO() {
    }

    public ReviewDTO(int reviewId, int rating, String comment, int userId, String userName, int productId) {
        this.reviewId = reviewId;
        this.rating = rating;
        this.comment = comment;
        this.userId = userId;
        this.userName = userName;
        this.productId = productId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}