package dev.alexengrig.spring.docker.producer.controller;

import dev.alexengrig.spring.docker.producer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/producing")
public class ProducerController {

    private final ProducerService service;

    @GetMapping
    public String produce() {
        return service.produce();
    }

}
