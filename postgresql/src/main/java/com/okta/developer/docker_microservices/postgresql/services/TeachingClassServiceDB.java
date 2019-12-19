package com.okta.developer.docker_microservices.postgresql.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.okta.developer.docker_microservices.postgresql.dto.TeachingClassDto;
import com.okta.developer.docker_microservices.postgresql.repository.TeachingClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class TeachingClassServiceDB implements TeachingClassService {
    private final TeachingClassRepository teachingClassRepository;

    @Autowired
    public TeachingClassServiceDB(TeachingClassRepository teachingClassRepository) {
        this.teachingClassRepository = teachingClassRepository;
    }

    @Override

    @HystrixCommand(fallbackMethod = "buildFallbackTeachingClass",
            commandProperties=
                    //Set an specific time out
                    {@HystrixProperty(
                            name="execution.isolation.thread.timeoutInMilliseconds",
                            value="8000")
                    },
            //Define a pool of threads just for listClasses
            threadPoolKey = "listClasses",
            threadPoolProperties =
                    //Max number of threads on the pool
                    {@HystrixProperty(name = "coreSize",value="3"),
                            //Max number of request in the queue of each thread
                            @HystrixProperty(name="maxQueueSize", value="10")})
    public List<TeachingClassDto> listClasses() {
        //Sleep 1 of 3 request more than 1000 Ms or 1 Second to throw timeout due Hystrix default configuration
        randomlyRunLong();

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

    public List<TeachingClassDto> buildFallbackTeachingClass() {
        List<TeachingClassDto> teachingClassDtos = new ArrayList<>();

        teachingClassDtos.add(TeachingClassDto
                .builder()
                .teacherName("testTeacher")
                .teacherId(1)
                .numberOfStudents(1)
                .classId(1)
                .courseId(1)
                .courseName("testCourse")
                .year(2019)
                .build());

        return teachingClassDtos;
    }

    private void randomlyRunLong(){
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;

        if (randomNum==3) sleep(11000);
    }

    private void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}