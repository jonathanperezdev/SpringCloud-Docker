package com.okta.developer.docker_microservices.postgresql.controllers;

import com.okta.developer.docker_microservices.postgresql.dto.TeachingClassDto;
import com.okta.developer.docker_microservices.postgresql.services.Example;
import com.okta.developer.docker_microservices.postgresql.services.TeachingClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeachingClassController {

    @Autowired
    private TeachingClassService teachingClassService;

    @Autowired
    private Example example;

    @GetMapping("/class")
    public List<TeachingClassDto> listClasses(){
        return teachingClassService.listClasses();
    }

    @GetMapping("/exampleProperty")
    public String getExampleProperty(){
        return example.getExampleProperty();
    }
}