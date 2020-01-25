package com.mellies.ra.api.consumers.service;

import com.mellies.ra.api.consumers.repository.ConsumerRepository;
import exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import models.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    public Iterable<Consumer> findAll(){
        log.info("Find all consumers");
        return consumerRepository.findAll();
    }

    public Consumer findById(String consumerId) throws ResourceNotFoundException {
        log.info("Find consumer with id " + consumerId);
        return consumerRepository
                .findById(consumerId)
                .orElseThrow(() -> new ResourceNotFoundException("Consumer not found on :: " + consumerId));
    }

    public Consumer save(Consumer consumer){
        log.info("Save consumer");
        return consumerRepository.save(consumer);
    }

    public Consumer update(String consumerId, Consumer consumerDetails) throws ResourceNotFoundException {
        log.info("Update consumer with id " + consumerId);
        Consumer consumer = findById(consumerId);
        consumer.setName(consumerDetails.getName());
        return save(consumer);
    }

    public void delete(String consumerId) throws ResourceNotFoundException {
        log.info("Delete consumer with id " + consumerId);
        Consumer consumer = findById(consumerId);
        consumerRepository.delete(consumer);
    }

}
