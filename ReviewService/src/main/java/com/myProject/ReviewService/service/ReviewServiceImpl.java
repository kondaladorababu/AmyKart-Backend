package com.myProject.ReviewService.service;

import com.myProject.ReviewService.dto.ReviewRequestDTO;
import com.myProject.ReviewService.dto.ReviewResponseDTO;
import com.myProject.ReviewService.model.Review;
import com.myProject.ReviewService.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public String addReview(int productId, ReviewRequestDTO reviewRequest) {
        Review review = new Review();
        review.setProductId(productId);
        review.setUserId(reviewRequest.getUserId());
        review.setUsername(reviewRequest.getUserName());
        review.setRating(reviewRequest.getRating());
        review.setComment(reviewRequest.getReviewText());
        reviewRepository.save(review);
        return "Review added successfully!";
    }

    public String updateReview(int productId, int reviewId, ReviewRequestDTO reviewRequest) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null && review.getProductId() == (productId) && review.getUserId() == (reviewRequest.getUserId())) {
            review.setRating(reviewRequest.getRating());
            review.setComment(reviewRequest.getReviewText());
            reviewRepository.save(review);
            return "Review updated successfully!";
        }
        return "Review not found or not authorized!";
    }

    public List<ReviewResponseDTO> getReviewsByProductId(int productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews.stream().map(review -> {
            ReviewResponseDTO responseDTO = new ReviewResponseDTO();
            responseDTO.setReviewId(review.getId());
            responseDTO.setProductId(review.getProductId());
            responseDTO.setUserId(review.getUserId());
            responseDTO.setUserName(review.getUsername());
            responseDTO.setRating(review.getRating());
            responseDTO.setReviewText(review.getComment());
            return responseDTO;
        }).collect(Collectors.toList());
    }

    public String deleteReview(int reviewId) {
        Review review = reviewRepository.findById(reviewId).orElse(null);
        if (review != null) {
            reviewRepository.delete(review);
            return "Review deleted successfully!";
        }
        return "Review not found!";
    }
}