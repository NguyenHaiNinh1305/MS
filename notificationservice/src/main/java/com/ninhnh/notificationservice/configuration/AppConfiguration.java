package com.ninhnh.notificationservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfiguration {
//    @Bean
//    public WebClient.Builder getWebClientBuilder(){
//        return WebClient.builder();
//    }
//    @Bean
//    public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer(){
//        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
//                .timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(3)).build())
//                .circuitBreakerConfig(CircuitBreakerConfig.custom()
//                        .slidingWindowSize(10)
//                        .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.TIME_BASED)
//                        .minimumNumberOfCalls(5)
//                        .failureRateThreshold(50)
//                        .build()
//                ).build()
//        );
//    }
}