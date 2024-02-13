package gr.codehub.firsteuropeandynapp.metricservice;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final Counter eventCounter;
    @Autowired
    public EventService(MeterRegistry meterRegistry) {
        this.eventCounter = Counter.builder("events.total")
                .description("Total number of events")
                .register(meterRegistry);
    }

    public void processEvent(){
        eventCounter.increment();
    }
}
