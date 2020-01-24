package com.mellies.ra.api.complaints.service;

import com.mellies.ra.api.complaints.client.CompanyClient;
import com.mellies.ra.api.complaints.client.ConsumerClient;
import com.mellies.ra.api.complaints.repository.ComplaintRepository;
import dto.ComplaintCreateDTO;
import dto.ComplaintUpdateDTO;
import exceptions.ResourceNotFoundException;
import models.Company;
import models.Complaint;
import models.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    CompanyClient companyClient;

    @Autowired
    ConsumerClient consumerClient;

    public Iterable<Complaint> findAll(){
        return complaintRepository.findAll();
    }

    public Complaint findById(String complaintId) throws ResourceNotFoundException {
        return complaintRepository
                .findById(complaintId)
                .orElseThrow(() -> new ResourceNotFoundException("Complaint not found on :: " + complaintId));
    }

    public Complaint save(ComplaintCreateDTO complaintDto) throws ResourceNotFoundException {
        return complaintRepository.save(converterDTO(complaintDto));
    }

    public Complaint update(String consumerId, ComplaintUpdateDTO complaintDetails) throws ResourceNotFoundException {
        Complaint complaint = findById(consumerId);
        complaint.setTitle(complaintDetails.getTitle());
        complaint.setDescription(complaintDetails.getDescription());
        complaint.setUpdateAt(LocalDateTime.now());
        return complaintRepository.save(complaint);
    }

    public void delete(String complaintId) throws ResourceNotFoundException {
        Complaint complaint = findById(complaintId);
        complaintRepository.delete(complaint);
    }

    private Complaint converterDTO(ComplaintCreateDTO complaintDTO) throws ResourceNotFoundException {
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
