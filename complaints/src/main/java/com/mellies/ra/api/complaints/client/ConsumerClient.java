package com.mellies.ra.api.complaints.client;

import models.Consumer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient("api-consumers")
public interface ConsumerClient {

    @GetMapping("/{consumerId}")
    Optional<Consumer> getConsumerById(@PathVariable("consumerId") String consumerId);

}
