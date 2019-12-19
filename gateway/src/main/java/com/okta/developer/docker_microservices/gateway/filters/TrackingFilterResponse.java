package com.okta.developer.docker_microservices.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class TrackingFilterResponse implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String correlationId = exchange.getRequest().getHeaders().getFirst("tmx-correlation-id");
        exchange.getResponse().getHeaders().add("tmx-correlation-id", correlationId);


        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
