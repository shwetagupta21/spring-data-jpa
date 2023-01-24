package com.springbootproject.springdatajpa.repository;

import com.springbootproject.springdatajpa.entity.Course;
import com.springbootproject.springdatajpa.entity.Student;
import com.springbootproject.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    public void printCourses() {
        List<Course> course = courseRepository.findAll();
        System.out.println("courses=" + course);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageableThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageableThreeRecords =
                PageRequest.of(1, 2);
        List<Course> courses =
                courseRepository.findAll(secondPageableThreeRecords).getContent();
        Long totalElements =
                courseRepository.findAll(secondPageableThreeRecords).getTotalElements();

        int totalPages =
                courseRepository.findAll(secondPageableThreeRecords)
                        .getTotalPages();
        System.out.println("totalpages=" + totalPages);

        System.out.println("totalElements=" + totalElements);
        System.out.println("courses=" + courses);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0, 2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0, 2,
                Sort.by("credit")
                        .descending()
        );
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0, 2,
                        Sort.by("title")
                                .descending()
                                .and(Sort.by("credit"))
                );
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses=" + courses);

    }

    @Test
    public void printFindByTitleContaining() {
        Pageable firstPageTenRecords =
                PageRequest.of(0, 10);

        List<Course> courses =
                courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();

        System.out.println("courses= " + courses);
    }
    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher=Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();
        Student student= Student.builder()
                .firstName("Abhishek")
                .lastName("Singh")
                .emailId("abhishek@gmail.com")
                .build();
        Course course=Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);
        courseRepository.save(course);
    }
}