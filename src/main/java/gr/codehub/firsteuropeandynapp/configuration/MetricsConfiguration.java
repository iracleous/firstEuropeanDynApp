package gr.codehub.firsteuropeandynapp.configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.logging.LoggingMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MetricsConfiguration {

    @Bean
    public MeterRegistry customMeterRegistry() {
        return new LoggingMeterRegistry();
    }
}
