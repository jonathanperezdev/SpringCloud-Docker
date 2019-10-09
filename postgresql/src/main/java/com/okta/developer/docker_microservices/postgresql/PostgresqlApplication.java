package com.okta.developer.docker_microservices.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class PostgresqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresqlApplication.class, args);
	}

}
