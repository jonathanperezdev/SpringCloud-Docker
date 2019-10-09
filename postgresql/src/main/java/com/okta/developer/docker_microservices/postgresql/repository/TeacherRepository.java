package com.okta.developer.docker_microservices.postgresql.repository;

import com.okta.developer.docker_microservices.postgresql.entities.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, UUID> {
}
