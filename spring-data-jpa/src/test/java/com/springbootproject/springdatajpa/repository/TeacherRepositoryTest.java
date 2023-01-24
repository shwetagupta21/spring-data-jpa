package com.springbootproject.springdatajpa.repository;

import com.springbootproject.springdatajpa.entity.Course;
import com.springbootproject.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseJAVA = Course.builder()
                .title("JAVA")
                .credit(6)
                .build();


        Teacher teacher=Teacher.builder()
                .firstName("Shweta")
                .lastName("Gupta")
        //        .courses(List.of(courseDBA,courseJAVA))
                .build();

        teacherRepository.save(teacher);
    }
}