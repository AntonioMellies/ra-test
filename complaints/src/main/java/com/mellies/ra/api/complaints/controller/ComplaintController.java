package com.mellies.ra.api.complaints.controller;

import com.mellies.ra.api.complaints.service.ComplaintService;
import dto.ComplaintCreateDTO;
import dto.ComplaintLocationConsultDTO;
import dto.ComplaintUpdateDTO;
import exceptions.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import models.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/")
@Api("Operations pertaining to complaint")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    /*
    * CRUD
    * */
    @ApiOperation(value = "View a list of complaints")
    @GetMapping("/")
    public Iterable<Complaint> getAllComplaints() {
        return complaintService.findAll();
    }

    @ApiOperation(value = "Get an complaint by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintsById(@PathVariable(value = "id") String complaintId) throws ResourceNotFoundException {
        Complaint complaint = complaintService.findById(complaintId);
        return ResponseEntity.ok().body(complaint);
    }

    @ApiOperation(value = "Add an complaint")
    @PostMapping("/")
    public ResponseEntity<Complaint> createComplaint(@Valid @RequestBody ComplaintCreateDTO complaintCreateDTO) throws ResourceNotFoundException {
        Complaint newComplaint = complaintService.save(complaintCreateDTO);
        return ResponseEntity.ok().body(newComplaint);
    }

    @ApiOperation(value = "Update an complaint")
    @PutMapping("/{id}")
    public ResponseEntity<Complaint> updateComplaint(
            @PathVariable(value = "id") String complaintId, @Valid @RequestBody ComplaintUpdateDTO complaintDetails)
            throws ResourceNotFoundException {
        final Complaint updatedComplaint = complaintService.update(complaintId, complaintDetails);
        return ResponseEntity.ok(updatedComplaint);
    }

    @ApiOperation(value = "Delete an complaint")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteComplaint(@PathVariable(value = "id") String complaintId) throws Exception {
        complaintService.delete(complaintId);
        return ResponseEntity.noContent().build();
    }

    /*
    * INFORMATIONS
    * */
    @ApiOperation(value = "View a list of complaints filtered by consumer id")
    @GetMapping("/consumer/id/{id}")
    public ResponseEntity<Iterable<Complaint>> getComplaintsByConsumerId(@PathVariable(value = "id") String consumerId) {
        Iterable<Complaint> complaints = complaintService.getComplaintsByConsumerId(consumerId);
        return ResponseEntity.ok().body(complaints);
    }

    @ApiOperation(value = "View a list of complaints filtered by company id")
    @GetMapping("/company/id/{id}")
    public ResponseEntity<Iterable<Complaint>> getComplaintsByCompanyId(@PathVariable(value = "id") String companyId) {
        Iterable<Complaint> complaints = complaintService.getComplaintsByCompanyId(companyId);
        return ResponseEntity.ok().body(complaints);
    }

    @ApiOperation(value = "View a list of complaints filtered by company name")
    @GetMapping("/company/name/{name}")
    public ResponseEntity<Iterable<Complaint>> getComplaintsByCompanyName(@PathVariable(value = "name") String companyName) {
        Iterable<Complaint> complaints = complaintService.getComplaintsByCompanyName(companyName);
        return ResponseEntity.ok().body(complaints);
    }

    @ApiOperation(value = "View a list of complaints filtered by company city")
    @GetMapping("/company/city/{name}")
    public ResponseEntity<Iterable<Complaint>> getComplaintsByCompanyCity(@PathVariable(value = "name") String cityName) {
        Iterable<Complaint> complaints = complaintService.getComplaintsByCompanyCity(cityName);
        return ResponseEntity.ok().body(complaints);
    }

    @ApiOperation(value = "View a list of complaints filtered by company state")
    @GetMapping("/company/state/{name}")
    public ResponseEntity<Iterable<Complaint>> getComplaintsByCompanyState(@PathVariable(value = "name") String stateName) {
        Iterable<Complaint> complaints = complaintService.getComplaintsByCompanyState(stateName);
        return ResponseEntity.ok().body(complaints);
    }

    @ApiOperation(value = "View a list of complaints filtered by company country")
    @GetMapping("/company/country/{name}")
    public ResponseEntity<Iterable<Complaint>> getComplaintsByCompanyCountry(@PathVariable(value = "name") String countrName) {
        Iterable<Complaint> complaints = complaintService.getComplaintsByCompanyCountry(countrName);
        return ResponseEntity.ok().body(complaints);
    }

    @ApiOperation(value = "View a list of complaints filtered by company locations")
    @PostMapping("/company/location")
    public ResponseEntity<Iterable<Complaint>> getComplaintsByCompanyLocation(@Valid @RequestBody ComplaintLocationConsultDTO complaintLocationConsultDTO) {
        Iterable<Complaint> complaints = complaintService.getComplaintsByCompanyLocation(complaintLocationConsultDTO);
        return ResponseEntity.ok().body(complaints);
    }

}
