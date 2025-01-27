package com.myProject.ReviewService.dto;

public class ReviewRequestDTO {
    private int productId;
    private int userId;
    private String userName;
    private int rating;
    private String comment;

    public ReviewRequestDTO() {
    }

    public ReviewRequestDTO(int productId, int userId, int rating,String userName, String comment) {
        this.productId = productId;
        this.userId = userId;
        this.userName=userName;
        this.rating = rating;
        this.comment = comment;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
