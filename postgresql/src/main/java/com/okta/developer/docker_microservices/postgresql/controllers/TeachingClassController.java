package com.okta.developer.docker_microservices.postgresql.controllers;

import com.okta.developer.docker_microservices.postgresql.dto.TeachingClassDto;
import com.okta.developer.docker_microservices.postgresql.services.TeachingClassService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeachingClassController {


    private final TeachingClassService teachingClassService;

    public TeachingClassController(TeachingClassService teachingClassService) {
        this.teachingClassService = teachingClassService;
    }

    @GetMapping("/class")
    public List<TeachingClassDto> listClasses(){
        return teachingClassService.listClasses();
    }

    @GetMapping("/exampleProperty")
    public String getExampleProperty(){
        return teachingClassService.getExampleProperty();
    }
}