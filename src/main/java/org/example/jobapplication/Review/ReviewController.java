package org.example.jobapplication.Review;

import org.example.jobapplication.Company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews(@PathVariable Long companyId){
        return reviewService.getAllReviews(companyId);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
        return reviewService.addReview(companyId,review);
    }
    
}
