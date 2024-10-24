package org.example.jobapplication.Company.Repository;

import org.example.jobapplication.Company.Company;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyRepository {
    List<Company> getAllCompanies();

    ResponseEntity<Company> getCompanyById(Long id);

    ResponseEntity<String> addCompany(Company company);

    ResponseEntity<String> updateCompany(Long id,Company company);

    ResponseEntity<String > deleteCompany(Long id);
}
