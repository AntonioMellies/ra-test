package com.mellies.ra.api.consumers.controller;

import com.mellies.ra.api.consumers.service.ConsumerService;
import exceptions.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import models.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/")
@Api("Operations pertaining to consumer")
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @ApiOperation(value = "View a list of consumers")
    @GetMapping("/")
    public Iterable<Consumer> getAllConsumers() {
        return consumerService.findAll();
    }

    @ApiOperation(value = "Get an consumer by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Consumer> getConsumerById(@PathVariable(value = "id") String consumerId) throws ResourceNotFoundException {
        Consumer consumer = consumerService.findById(consumerId);
        return ResponseEntity.ok().body(consumer);
    }

    @ApiOperation(value = "Add an consumer")
    @PostMapping("/")
    public ResponseEntity<Consumer> createConsumer(@Valid @RequestBody Consumer consumer) {
        Consumer newConsumer = consumerService.save(consumer);
        return ResponseEntity.ok().body(newConsumer);
    }

    @ApiOperation(value = "Update an consumer")
    @PutMapping("/{id}")
    public ResponseEntity<Consumer> updateConsumer(
            @PathVariable(value = "id") String consumerId, @Valid @RequestBody Consumer consumerDetails)
            throws ResourceNotFoundException {
        final Consumer updatedConsumer = consumerService.update(consumerId, consumerDetails);
        return ResponseEntity.ok(updatedConsumer);
    }

    @ApiOperation(value = "Delete an consumer")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteConsumer(@PathVariable(value = "id") String consumerId) throws Exception {
        consumerService.delete(consumerId);
        return ResponseEntity.noContent().build();
    }

}
