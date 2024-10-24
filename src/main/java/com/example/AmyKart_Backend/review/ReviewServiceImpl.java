package com.example.AmyKart_Backend.review;

import com.example.AmyKart_Backend.product.Product;
import com.example.AmyKart_Backend.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Review> findByProductId(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElse(null);
        if (product == null) {
            return null;
        }
        return product.getReview();
    }

    @Override
    public void createReview(Review review) {
        Product product = productRepository.findById(review.getProduct().getId())
                .orElse(null);

        //never happens
        if (product == null) {
            return;
        }
        review.setProduct(product);
        reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Integer id) {
        return reviewRepository.findById(id).orElse(null);
    }



    @Override
    public boolean updateReview(Integer id, Review review) {
        if (reviewRepository.existsById(id)) {
            Review existingReview = reviewRepository.findById(id).orElse(null);
            if (existingReview != null) {
                existingReview.setRating(review.getRating());
                existingReview.setReview(review.getReview());
                existingReview.setUserId(review.getUserId());
                reviewRepository.save(existingReview);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteReview(Integer id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
