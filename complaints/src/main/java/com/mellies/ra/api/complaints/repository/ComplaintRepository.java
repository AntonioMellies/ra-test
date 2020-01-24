package com.mellies.ra.api.complaints.repository;

import models.Complaint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComplaintRepository extends MongoRepository<Complaint,String> {

}
