package dev.alexengrig.spring.docker.producer.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MeterProduceServiceMetric implements ProduceServiceMetric, MeterBinder {

    private Counter counter;

    @Override
    public void incProduced() {
        if (counter == null) {
            throw new IllegalStateException("No counter");
        }
        counter.increment();
    }

    @Override
    public void bindTo(MeterRegistry registry) {
        if (counter != null) {
            throw new IllegalStateException("Already has a counter");
        }
        counter = registry.counter("produce.count");
    }

}
