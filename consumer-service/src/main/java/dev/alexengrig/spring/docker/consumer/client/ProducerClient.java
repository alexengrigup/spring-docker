package dev.alexengrig.spring.docker.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "producer-service", path = "/api/producing")
public interface ProducerClient {

    @GetMapping
    String produce();

}
