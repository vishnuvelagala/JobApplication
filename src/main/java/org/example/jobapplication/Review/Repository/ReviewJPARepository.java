package org.example.jobapplication.Review.Repository;

import org.example.jobapplication.Review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewJPARepository extends JpaRepository<Review,Long> {
    List<Review> findByCompanyId(Long companyId);
}
