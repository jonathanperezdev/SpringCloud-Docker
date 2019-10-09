package com.okta.developer.docker_microservices.postgresql.repository;

import com.okta.developer.docker_microservices.postgresql.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findByNameContaining(String name);

    List<Student> findByAgeBetween(short smallerAge, short biggerAge);

}
