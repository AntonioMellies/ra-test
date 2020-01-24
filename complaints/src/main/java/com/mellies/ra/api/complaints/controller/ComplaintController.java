package com.mellies.ra.api.complaints.controller;

import com.mellies.ra.api.complaints.service.ComplaintService;
import dto.ComplaintCreateDTO;
import dto.ComplaintUpdateDTO;
import exceptions.ResourceNotFoundException;
import models.Complaint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;


    @GetMapping("/")
    public Iterable<Complaint> getAllComplaints() {
        return complaintService.findAll();
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<Complaint> getComplaintsById(@PathVariable(value = "id") String complaintId) throws ResourceNotFoundException {
        Complaint complaint = complaintService.findById(complaintId);
        return ResponseEntity.ok().body(complaint);
    }
   
    @PostMapping("/")
    public ResponseEntity<Complaint> createComplaint(@Valid @RequestBody ComplaintCreateDTO complaintCreateDTO) throws ResourceNotFoundException {
        Complaint newComplaint = complaintService.save(complaintCreateDTO);
        return ResponseEntity.ok().body(newComplaint);
    }
   
    @PutMapping("/{id}")
    public ResponseEntity<Complaint> updateComplaint(
            @PathVariable(value = "id") String complaintId, @Valid @RequestBody ComplaintUpdateDTO complaintDetails)
            throws ResourceNotFoundException {
        final Complaint updatedComplaint = complaintService.update(complaintId, complaintDetails);
        return ResponseEntity.ok(updatedComplaint);
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteComplaint(@PathVariable(value = "id") String complaintId) throws Exception {
        complaintService.delete(complaintId);
        return ResponseEntity.noContent().build();
    }

}
