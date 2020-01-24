package com.mellies.ra.api.companies.repository;

import models.Company;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company,String> {

}
