package com.okta.developer.docker_microservices.postgresql.services;

import com.okta.developer.docker_microservices.postgresql.dto.TeachingClassDto;
import com.okta.developer.docker_microservices.postgresql.repository.TeachingClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class TeachingClassServiceDB implements TeachingClassService {
    @Value("${example.property}")
    private String exampleProperty;

    private final TeachingClassRepository teachingClassRepository;

    @Autowired
    public TeachingClassServiceDB(TeachingClassRepository teachingClassRepository) {
        this.teachingClassRepository = teachingClassRepository;
    }

    @Override
    public List<TeachingClassDto> listClasses() {

        return teachingClassRepository
                .findAll()
                .stream()
                .map( classObj -> TeachingClassDto
                        .builder()
                        .teacherName( classObj.getTeacher().getName() )
                        .teacherId( classObj.getTeacher().getId() )
                        .numberOfStudents( classObj.getStudents().size() )
                        .classId( classObj.getId() )
                        .courseId( classObj.getCourse().getId() )
                        .courseName( classObj.getCourse().getName() )
                        .year( classObj.getYear() )
                        .build()
                )
                .collect(Collectors.toList());
    }

    @Override
    public String getExampleProperty(){
        return this.exampleProperty;
    }
}