package com.okta.developer.docker_microservices.ui.controller;

import com.okta.developer.docker_microservices.ui.dto.TeachingClassDto;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/")
public class SchoolController {
    private final RestTemplate restTemplate;

    public SchoolController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/class")
    public ResponseEntity<List<TeachingClassDto>> listClasses(){
        return restTemplate
                .exchange("http://GATEWAY/POSTGRESQL/class", HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<TeachingClassDto>>() {});
    }

    @GetMapping("/exampleProperty")
    public ResponseEntity<String> exampleProperty(){
        return restTemplate
                .exchange("http://GATEWAY/POSTGRESQL/exampleProperty", HttpMethod.GET, null,
                        String.class);
    }
}
