package com.okta.developer.docker_microservices.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker

@RefreshScope
public class PostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresqlApplication.class, args);
	}

}
