package com.okta.developer.docker_microservices.postgresql.services;

import com.okta.developer.docker_microservices.postgresql.entities.Course;
import com.okta.developer.docker_microservices.postgresql.entities.Student;
import com.okta.developer.docker_microservices.postgresql.entities.Teacher;
import com.okta.developer.docker_microservices.postgresql.entities.TeachingClass;
import com.okta.developer.docker_microservices.postgresql.repository.CourseRepository;
import com.okta.developer.docker_microservices.postgresql.repository.StudentRepository;
import com.okta.developer.docker_microservices.postgresql.repository.TeacherRepository;
import com.okta.developer.docker_microservices.postgresql.repository.TeachingClassRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class DataFillerService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final TeachingClassRepository teachingClassRepository;
    private final StudentRepository studentRepository;

    public DataFillerService(CourseRepository courseRepository, TeacherRepository teacherRepository, TeachingClassRepository teachingClassRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.teacherRepository = teacherRepository;
        this.teachingClassRepository = teachingClassRepository;
        this.studentRepository = studentRepository;
    }

    @PostConstruct
    @Transactional
    public void fillData(){


        Teacher pj = new Teacher(
                "Profesor Jirafales",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Ruben2017.jpg/245px-Ruben2017.jpg",
                "jirafales@yahoo_.com"
        );

        Teacher px = new Teacher(
                "Professor X",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9uI1Cb-nQ2uJOph4_t96KRvLSMjczAKnHLJYi1nqWXagvqWc4",
                "director@xproject_.com"

        );

        teacherRepository.save(pj);
        teacherRepository.save(px);

        // create courses
        Course mathematics = new Course("Mathematics", 20, (short) 10);
        Course spanish = new Course("Spanish", 20, (short) 10);
        Course dealingWithUnknown = new Course("Dealing with unknown", 10, (short) 100);
        Course handlingYourMentalPower = new Course("Handling your mental power", 50, (short) 100);
        Course introductionToPsychology = new Course("Introduction to psychology", 90, (short) 100);

        courseRepository.save(mathematics);
        courseRepository.save(spanish);
        courseRepository.save(dealingWithUnknown);
        courseRepository.save(handlingYourMentalPower);
        courseRepository.save(introductionToPsychology);

        // classes

        Student studendChaves = studentRepository.save(new Student("Chaves", (short) 34));
        Student studendQuico = studentRepository.save(new Student("Quico", (short) 35));
        Student studendCyclops = studentRepository.save(new Student("Cyclops", (short) 25));
        Student studentIceman = studentRepository.save(new Student("Iceman", (short) 30));
        Student studendArchangel = studentRepository.save(new Student("Archangel", (short) 29));

        teachingClassRepository.save(
                new TeachingClass(mathematics, pj, Arrays.asList(studendChaves, studendQuico), 1988)
        );

        teachingClassRepository.save(
                new TeachingClass(spanish, pj, Arrays.asList(studendChaves, studendQuico), 1988)
        );

        teachingClassRepository.save(
                new TeachingClass(dealingWithUnknown, px, Arrays.asList(studendCyclops, studentIceman), 1995)
        );

        teachingClassRepository.save(
                new TeachingClass(dealingWithUnknown, px, Arrays.asList(studendArchangel), 1996)
        );
    }
}
