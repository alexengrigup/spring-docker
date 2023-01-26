package dev.alexengrig.spring.docker.consumer.service;

import dev.alexengrig.spring.docker.consumer.client.ProducerClient;
import dev.alexengrig.spring.docker.consumer.metric.ConsumerServiceMetric;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumerServiceImpl implements ConsumerService {

    private final ProducerClient client;
    private final ConsumerServiceMetric metric;

    @Override
    public String consume() {
        String data = client.produce();
        log.info("Consumed: {}", data);
        metric.incConsumed();
        return data;
    }

}
