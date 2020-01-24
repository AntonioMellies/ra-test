package com.mellies.ra.api.companies.controller;

import com.mellies.ra.api.companies.service.CompanyService;
import dto.CompanyDTO;
import exceptions.ResourceNotFoundException;
import models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/")
public class CompanyController {

    @Autowired
    CompanyService companyService;


    @GetMapping("/")
    public Iterable<Company> getAllCompanys() {
        return companyService.findAll();
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanysById(@PathVariable(value = "id") String companyId) throws ResourceNotFoundException {
        Company company = companyService.findById(companyId);
        return ResponseEntity.ok().body(company);
    }
   
    @PostMapping("/")
    public ResponseEntity<Company> createCompany(@Valid @RequestBody CompanyDTO company) {
        Company newCompany = companyService.save(company);
        return ResponseEntity.ok().body(newCompany);
    }
   
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(
            @PathVariable(value = "id") String companyId, @Valid @RequestBody CompanyDTO companyDetails)
            throws ResourceNotFoundException {
        final Company updatedCompany = companyService.update(companyId, companyDetails);
        return ResponseEntity.ok(updatedCompany);
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCompany(@PathVariable(value = "id") String companyId) throws Exception {
        companyService.delete(companyId);
        return ResponseEntity.noContent().build();
    }

}
