package org.example.jobapplication.Review;


import org.example.jobapplication.Company.Company;
import org.example.jobapplication.Company.CompanyService;
import org.example.jobapplication.Review.Repository.ReviewJPARepository;
import org.example.jobapplication.Review.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements ReviewRepository {

    @Autowired
    private ReviewJPARepository reviewJPARepository;

    @Autowired
    private CompanyService companyService;
    @Override
    public List<Review> getAllReviews(Long id) {
        List<Review> reviews = reviewJPARepository.findByCompanyId(id);
        return reviews;
    }

    @Override
    public ResponseEntity<String> addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId).getBody();
        if(company != null){
            review.setCompany(company);
            reviewJPARepository.save(review);
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Failed to add review", HttpStatus.NOT_FOUND);
        }

    }
}
