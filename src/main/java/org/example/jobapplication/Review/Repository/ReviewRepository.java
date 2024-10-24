package org.example.jobapplication.Review.Repository;

import org.example.jobapplication.Review.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewRepository {
    List<Review> getAllReviews(Long id);

    ResponseEntity<String> addReview(Long companyId,Review review);
}
