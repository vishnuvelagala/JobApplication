package org.example.jobapplication.Company;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id){
        return companyService.getCompanyById(id);
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company){
        return companyService.addCompany(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Company company,@PathVariable("id") Long id){
        return companyService.updateCompany(id,company);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMapping(@PathVariable("id") Long id){
        return companyService.deleteCompany(id);
    }
}
