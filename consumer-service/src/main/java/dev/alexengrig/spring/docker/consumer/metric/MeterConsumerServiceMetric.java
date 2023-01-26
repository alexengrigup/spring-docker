package dev.alexengrig.spring.docker.consumer.metric;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MeterConsumerServiceMetric implements ConsumerServiceMetric, MeterBinder {

    private Counter counter;

    @Override
    public void incConsumed() {
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
        counter = registry.counter("consume.count");
    }

}
