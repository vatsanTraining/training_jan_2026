package com.example;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.ReactiveResilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@SpringBootApplication
public class CbBreakerDemoClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbBreakerDemoClientApplication.class, args);
    }

    @Bean
    WebClient.Builder builder() {
        return WebClient.builder();
    }

    @Bean
    WebClient client(WebClient.Builder builderRef) {
        return builderRef.build();
    }


    @Bean
     Customizer<ReactiveResilience4JCircuitBreakerFactory> defaultCustomizer(){

        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(CircuitBreakerConfig.ofDefaults()).build());

    }







}
