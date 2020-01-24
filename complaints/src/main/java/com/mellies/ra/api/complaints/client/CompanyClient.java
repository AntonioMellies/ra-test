package com.mellies.ra.api.complaints.client;

import models.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient("api-companies")
public interface CompanyClient {

    @GetMapping("/{companyId}")
    Optional<Company> getCompanyById(@PathVariable("companyId") String companyId);

}
