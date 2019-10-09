package com.okta.developer.docker_microservices.postgresql.repository;

import com.okta.developer.docker_microservices.postgresql.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseRepository extends CrudRepository<Course, UUID> {}