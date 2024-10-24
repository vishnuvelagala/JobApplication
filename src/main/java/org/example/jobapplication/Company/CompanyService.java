package org.example.jobapplication.Company;

import org.example.jobapplication.Company.Repository.CompanyJPARepository;
import org.example.jobapplication.Company.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyService implements CompanyRepository{

    @Autowired
    CompanyJPARepository companyJPARepository;
    @Override
    public List<Company> getAllCompanies() {
        return companyJPARepository.findAll();
    }

    @Override
    public ResponseEntity<Company> getCompanyById(Long id) {
        try{
            return new ResponseEntity<>(companyJPARepository.findById(id).get(),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> addCompany(Company company) {
        try{
            companyJPARepository.save(company);
            return new ResponseEntity<>("Company added succesfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Failed to add Company",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<String> updateCompany(Long id,Company company) {
        try{
            Company existingCompany = companyJPARepository.findById(id).get();
            if(company.getName() != null){
                existingCompany.setName(company.getName());
            }
            if(company.getDescription() != null){
                existingCompany.setDescription(company.getDescription());
            }
            companyJPARepository.save(existingCompany);
            return new ResponseEntity<>("Updated successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Failed to update",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> deleteCompany(Long id){
        try{
            companyJPARepository.deleteById(id);
            return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Unable to delete",HttpStatus.NOT_FOUND);
        }
    }
}
