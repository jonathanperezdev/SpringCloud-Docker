package com.okta.developer.docker_microservices.postgresql.repository;

import com.okta.developer.docker_microservices.postgresql.entities.TeachingClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachingClassRepository extends JpaRepository<TeachingClass, Long> {
}
