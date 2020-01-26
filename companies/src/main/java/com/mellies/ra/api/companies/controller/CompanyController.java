package com.mellies.ra.api.companies.controller;

import com.mellies.ra.api.companies.service.CompanyService;
import dto.CompanyDTO;
import exceptions.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/")
@Api("Operations pertaining to company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ApiOperation(value = "View a list of companies")
    @GetMapping("/")
    public Iterable<Company> getAllCompanies() {
        return companyService.findAll();
    }

    @ApiOperation(value = "Get an company by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable(value = "id") String companyId) throws ResourceNotFoundException {
        Company company = companyService.findById(companyId);
        return ResponseEntity.ok().body(company);
    }

    @ApiOperation(value = "Add an company")
    @PostMapping("/")
    public ResponseEntity<Company> createCompany(@Valid @RequestBody CompanyDTO company) {
        Company newCompany = companyService.save(company);
        return ResponseEntity.ok().body(newCompany);
    }

    @ApiOperation(value = "Update an company")
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(
            @PathVariable(value = "id") String companyId, @Valid @RequestBody CompanyDTO companyDetails)
            throws ResourceNotFoundException {
        final Company updatedCompany = companyService.update(companyId, companyDetails);
        return ResponseEntity.ok(updatedCompany);
    }

    @ApiOperation(value = "Delete an company")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCompany(@PathVariable(value = "id") String companyId) throws Exception {
        companyService.delete(companyId);
        return ResponseEntity.noContent().build();
    }

}
