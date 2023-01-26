package dev.alexengrig.spring.docker.producer.controller;

import brave.Span;
import com.netflix.discovery.EurekaNamespace;
import dev.alexengrig.spring.docker.producer.service.ProducerService;
import io.micrometer.tracing.Tracer;
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
    @EurekaNamespace
    public String produce() {
        return service.produce();
    }

}
