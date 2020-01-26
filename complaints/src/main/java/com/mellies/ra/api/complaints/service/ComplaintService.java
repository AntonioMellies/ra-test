package com.mellies.ra.api.complaints.service;

import com.mellies.ra.api.complaints.client.CompanyClient;
import com.mellies.ra.api.complaints.client.ConsumerClient;
import com.mellies.ra.api.complaints.repository.ComplaintRepository;
import dto.ComplaintCreateDTO;
import dto.ComplaintLocationConsultDTO;
import dto.ComplaintUpdateDTO;
import exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import models.Company;
import models.Complaint;
import models.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private CompanyClient companyClient;

    @Autowired
    private ConsumerClient consumerClient;


    /*
    * CRUD
    * */
    public Iterable<Complaint> findAll(){
        log.info("Find all complaints");
        return complaintRepository.findAll();
    }

    public Complaint findById(String complaintId) throws ResourceNotFoundException {
        log.info("Find complaint with id " + complaintId);
        return complaintRepository
                .findById(complaintId)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint not found on :: " + complaintId));
    }

    public Complaint save(ComplaintCreateDTO complaintDto) throws ResourceNotFoundException {
        log.info("Save complaint");
        return complaintRepository.save(converterDTO(complaintDto));
    }

    public Complaint update(String complaintId, ComplaintUpdateDTO complaintDetails) throws ResourceNotFoundException {
        log.info("Update complaint with id " + complaintId);
        Complaint complaint = findById(complaintId);
        complaint.setTitle(complaintDetails.getTitle());
        complaint.setDescription(complaintDetails.getDescription());
        complaint.setUpdateAt(LocalDateTime.now());
        return complaintRepository.save(complaint);
    }

    public void delete(String complaintId) throws ResourceNotFoundException {
        log.info("Delete company with id " + complaintId);
        Complaint complaint = findById(complaintId);
        complaintRepository.delete(complaint);
    }

    /*
    * INFORMATIONS
    * */
    public Iterable<Complaint> getComplaintsByConsumerId(String consumerId){
        return complaintRepository.findAllByConsumerId(consumerId);
    }

    public Iterable<Complaint> getComplaintsByCompanyId(String companyId){
        return complaintRepository.findAllByCompanyId(companyId);
    }

    public Iterable<Complaint> getComplaintsByCompanyName(String companyName){
        return complaintRepository.findAllByCompanyName(companyName);
    }

    public Iterable<Complaint> getComplaintsByCompanyCity(String cityName){
        return complaintRepository.findAllByCompanyCity(cityName);
    }

    public Iterable<Complaint> getComplaintsByCompanyState(String stateName){
        return complaintRepository.findAllByCompanyState(stateName);
    }

    public Iterable<Complaint> getComplaintsByCompanyCountry(String countryName){
        return complaintRepository.findAllByCompanyCountry(countryName);
    }

    public Iterable<Complaint> getComplaintsByCompanyLocation(ComplaintLocationConsultDTO locationConsultDTO){
        return complaintRepository.findComplaintsByCompanyLocationNear(
                new Point(locationConsultDTO.getLongitude(), locationConsultDTO.getLatitude()),
                new Distance(locationConsultDTO.getDistance(), Metrics.KILOMETERS)
        );
    }

    /*
    * UTILS
    * */
    private Complaint converterDTO(ComplaintCreateDTO complaintDTO) throws ResourceNotFoundException {
        log.info("Complaint company");
        Complaint complaint = new Complaint();

        Company company = companyClient.getCompanyById(complaintDTO.getCompanyId())
                .orElseThrow(() -> new ResourceNotFoundException("Company not found on :: " + complaintDTO.getCompanyId()));

        Consumer consumer = consumerClient.getConsumerById(complaintDTO.getConsumerId())
                .orElseThrow(() -> new ResourceNotFoundException("Consumer not found on :: " + complaintDTO.getConsumerId()));

        complaint.setTitle(complaintDTO.getTitle());
        complaint.setDescription(complaintDTO.getDescription());
        complaint.setCompany(company);
        complaint.setConsumer(consumer);

        return complaint;
    }

}
