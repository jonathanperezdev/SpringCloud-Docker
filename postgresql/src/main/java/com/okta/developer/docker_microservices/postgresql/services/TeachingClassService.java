package com.okta.developer.docker_microservices.postgresql.services;

import java.util.List;

import com.okta.developer.docker_microservices.postgresql.dto.TeachingClassDto;

public interface TeachingClassService {
    List<TeachingClassDto> listClasses();

    String getExampleProperty();
}
