package com.myProject.ReviewService.service;

import com.myProject.ReviewService.dto.ReviewRequestDTO;
import com.myProject.ReviewService.dto.ReviewResponseDTO;

import java.util.List;

public interface ReviewService {

    public String addReview(int productId, ReviewRequestDTO reviewRequest);

    public String updateReview(int productId, int reviewId, ReviewRequestDTO reviewRequest);

    public List<ReviewResponseDTO> getReviewsByProductId(int productId);

    public String deleteReview(int reviewId);
}
