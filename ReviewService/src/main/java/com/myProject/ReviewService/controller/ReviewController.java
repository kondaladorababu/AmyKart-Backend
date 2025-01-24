package com.myProject.ReviewService.controller;

import com.myProject.ReviewService.dto.ReviewRequestDTO;
import com.myProject.ReviewService.dto.ReviewResponseDTO;
import com.myProject.ReviewService.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/{productId}")
    public ResponseEntity<String> addReview(@PathVariable int productId, @RequestBody ReviewRequestDTO reviewRequest) {
        String response = reviewService.addReview(productId, reviewRequest);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{productId}/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable int productId, @PathVariable int reviewId, @RequestBody ReviewRequestDTO reviewRequest) {
        String response = reviewService.updateReview(productId, reviewId, reviewRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsByProductId(@PathVariable int productId) {
        List<ReviewResponseDTO> reviews = reviewService.getReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable int reviewId) {
        String response = reviewService.deleteReview(reviewId);
        return ResponseEntity.ok(response);
    }
}