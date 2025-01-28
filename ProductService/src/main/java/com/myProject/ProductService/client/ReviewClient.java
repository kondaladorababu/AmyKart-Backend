package com.myProject.ProductService.client;


import com.myProject.ProductService.dto.ReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Review-Service", path = "/review")
public interface ReviewClient {

    @GetMapping("/{productId}")
    public List<ReviewDTO> getReviewsByProductId(@PathVariable int productId);
}
