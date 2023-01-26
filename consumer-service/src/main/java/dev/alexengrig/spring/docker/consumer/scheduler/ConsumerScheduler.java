package dev.alexengrig.spring.docker.consumer.scheduler;

import dev.alexengrig.spring.docker.consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class ConsumerScheduler {

    private final ConsumerService service;

    @Scheduled(fixedDelay = 5000L)
    public void consume() {
        log.info("Started consuming");
        service.consume();
        log.info("Finished consuming");
    }

}
