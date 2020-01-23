package com.mellies.ra.api.consumers.service;

import com.mellies.ra.api.consumers.repository.ConsumerRepository;
import exceptions.ResourceNotFoundException;
import models.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    public Iterable<Consumer> findAll(){
        return consumerRepository.findAll();
    }

    public Consumer findById(String consumerId) throws ResourceNotFoundException {
        return consumerRepository
                .findById(consumerId)
                .orElseThrow(() -> new ResourceNotFoundException("Consumer not found on :: " + consumerId));
    }

    public Consumer save(Consumer consumer){
        return consumerRepository.save(consumer);
    }

    public Consumer update(String consumerId, Consumer consumerDetails) throws ResourceNotFoundException {
        Consumer consumer = findById(consumerId);
        consumer.setName(consumerDetails.getName());
        return save(consumer);
    }

    public void delete(String consumerId) throws ResourceNotFoundException {
        Consumer consumer = findById(consumerId);
        consumerRepository.delete(consumer);
    }

}
