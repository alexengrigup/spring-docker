package dev.alexengrig.spring.docker.producer.service;

import dev.alexengrig.spring.docker.producer.metric.ProduceServiceMetric;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {

    private final ProduceServiceMetric metric;

    @Override
    public String produce() {
        String data = LocalTime.now().toString();
        log.info("Produced: {}", data);
        metric.incProduced();
        return data;
    }

}
