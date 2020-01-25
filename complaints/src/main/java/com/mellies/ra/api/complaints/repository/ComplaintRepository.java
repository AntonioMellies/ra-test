package com.mellies.ra.api.complaints.repository;

import models.Complaint;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.support.QuerydslMongoPredicateExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ComplaintRepository extends MongoRepository<Complaint,String> {


    Iterable<Complaint> findAllByConsumerId(String consumerId);

    Iterable<Complaint> findAllByCompanyId(String companyId);

    @Query("{'company.name' : { $regex: '.*?0.*', $options: 'i'}}")
    Iterable<Complaint> findAllByCompanyName(String companyName);

    @Query("{'company.city' : { $regex: '.*?0.*', $options: 'i'}}")
    Iterable<Complaint> findAllByCompanyCity(String cityName);

    @Query("{'company.state' : { $regex: '.*?0.*', $options: 'i'}}")
    Iterable<Complaint> findAllByCompanyState(String stateName);

    @Query("{'company.country' : { $regex: '.*?0.*', $options: 'i'}}")
    Iterable<Complaint> findAllByCompanyCountry(String countryName);

    Iterable<Complaint> findComplaintsByCompanyLocationNear(Point point, Distance distance);

}
