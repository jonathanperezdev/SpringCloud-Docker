package com.okta.developer.docker_microservices.gateway.config;

import com.okta.developer.docker_microservices.gateway.filters.TrackingFilterRequest;
import com.okta.developer.docker_microservices.gateway.filters.TrackingFilterResponse;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public GlobalFilter trackingFilterRequest() {
        return new TrackingFilterRequest();
    }

    @Bean
    public GlobalFilter trackingFilterResponse() {
        return new TrackingFilterResponse();
    }
}
