package com.mellies.ra.api.consumers.controller;

import com.mellies.ra.api.consumers.service.ConsumerService;
import exceptions.ResourceNotFoundException;
import models.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;


    @GetMapping("/")
    public Iterable<Consumer> getAllConsumers() {
        return consumerService.findAll();
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<Consumer> getConsumersById(@PathVariable(value = "id") String consumerId) throws ResourceNotFoundException {
        Consumer consumer = consumerService.findById(consumerId);
        return ResponseEntity.ok().body(consumer);
    }
   
    @PostMapping("/")
    public ResponseEntity<Consumer> createConsumer(@Valid @RequestBody Consumer consumer) {
        Consumer newConsumer = consumerService.save(consumer);
        return ResponseEntity.ok().body(newConsumer);
    }
   
    @PutMapping("/{id}")
    public ResponseEntity<Consumer> updateConsumer(
            @PathVariable(value = "id") String consumerId, @Valid @RequestBody Consumer consumerDetails)
            throws ResourceNotFoundException {
        final Consumer updatedConsumer = consumerService.update(consumerId, consumerDetails);
        return ResponseEntity.ok(updatedConsumer);
    }
   
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteConsumer(@PathVariable(value = "id") String consumerId) throws Exception {
        consumerService.delete(consumerId);
        return ResponseEntity.noContent().build();
    }

}
