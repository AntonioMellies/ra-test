package com.mellies.ra.api.consumers.repository;

import models.Consumer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConsumerRepository extends MongoRepository<Consumer,String> {

}
