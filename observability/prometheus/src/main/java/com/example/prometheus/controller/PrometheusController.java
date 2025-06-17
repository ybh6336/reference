package com.example.prometheus.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrometheusController {
  private static final String COUNTER = "custom.requests.count";

  private final String environment;
  private final MeterRegistry meterRegistry;

  public PrometheusController(@Value("${environment}") String environment, MeterRegistry meterRegistry) {
    this.environment = environment;
    this.meterRegistry = meterRegistry;

    Counter.builder(COUNTER)
        .tag("environment", environment)
        .register(meterRegistry);
  }

  @GetMapping("/incremented-counter")
  public Counter incrementCounter() {
    Counter counter = Counter.builder(COUNTER)
        .tag("environment", environment)
        .register(meterRegistry);
    counter.increment();
    return counter;
  }

}
