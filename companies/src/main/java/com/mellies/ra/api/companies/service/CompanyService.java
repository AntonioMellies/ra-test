package com.mellies.ra.api.companies.service;

import com.mellies.ra.api.companies.repository.CompanyRepository;
import dto.CompanyDTO;
import exceptions.ResourceNotFoundException;
import models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public Iterable<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company findById(String companyId) throws ResourceNotFoundException {
        return companyRepository
                .findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company not found on :: " + companyId));
    }

    public Company save(CompanyDTO companyDTO){
        return companyRepository.save(converterDTO(companyDTO));
    }

    public Company update(String companyId, CompanyDTO companyDTO) throws ResourceNotFoundException {
        Company company = findById(companyId);
        companyDTO.setId(company.getId());
        return save(companyDTO);
    }

    public void delete(String companyId) throws ResourceNotFoundException {
        Company company = findById(companyId);
        companyRepository.delete(company);
    }

    private Company converterDTO(CompanyDTO companyDTO){
        Company company = new Company();
        GeoJsonPoint geoJsonPoint  =new GeoJsonPoint(companyDTO.getLongitude(),companyDTO.getLatitude());

        company.setName(companyDTO.getName());
        company.setCity(companyDTO.getCity());
        company.setState(companyDTO.getState());
        company.setCountry(companyDTO.getCountry());
        company.setLocation(geoJsonPoint);

        return company;
    }

}
