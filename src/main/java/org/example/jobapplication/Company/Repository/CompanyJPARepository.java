package org.example.jobapplication.Company.Repository;


import org.example.jobapplication.Company.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyJPARepository extends JpaRepository<Company,Long> {
}
