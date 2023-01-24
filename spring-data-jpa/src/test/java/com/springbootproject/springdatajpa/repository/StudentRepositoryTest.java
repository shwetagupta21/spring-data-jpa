package com.springbootproject.springdatajpa.repository;

import com.springbootproject.springdatajpa.entity.Guardian;
import com.springbootproject.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {

@Autowired
private StudentRepository studentRepository;

// @Test
// public void saveStudent() {
//        Student student = Student.builder()
//        .emailId("cse21shweta@gmail.com")
//        .firstName("Shweta")
//        .lastName("Gupta")
//
//        //.guardianName("Nikhil")
//        //.guardianEmail("nikhil@gmail.com")
//        //.guardianMobile("9999999999")
//        .build();
//
//        studentRepository.save(student);
//        }

@Test
public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
        .email_id("shweta@gmail.com")
        .name("shweta")
        .mobile("7489057260")
        .build();

        Student student = Student.builder()
        .firstName("shivam")
        .emailId("shivam@gmail.com")
        .lastName("Gupta")
        .guardian(guardian)
        .build();
        studentRepository.save(student);
        }

    @Test
    public  void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("studentList= "+ studentList);
    }

    @Test
    public void printStudentByFirstName(){
    List<Student>students=studentRepository.findByFirstName("shivam");
    System.out.println("students= "+students);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student>students=
    studentRepository.findByFirstNameContaining("sh");
        System.out.println("students= "+students);
 }
 @Test
 public void findByLastName(){
     List<Student>students=
             studentRepository.findByLastName("Gupta");
     System.out.println("students= "+students);
 }

  @Test
    public void printStudentBasedOnGuardianName(){
      List<Student>students=
              studentRepository.findByGuardianName("shweta");
      System.out.println("students= "+students);
  }

 @Test
    public  void printGetStudentByEmailAddress(){
    Student student= studentRepository.getStudentByEmailAddress("shivam@gmail.com");
     System.out.println("students= "+student);
 }

    @Test
    public  void printGetStudentByFirstNameByEmailAddress(){
        String firstName= studentRepository.getStudentByFirstNameByEmailAddress("shivam@gmail.com");
        System.out.println("firstName= "+firstName);
}
    @Test
    public  void printGetStudentEmailAddressNative(){
        Student student= studentRepository.getStudentByEmailAddress("shivam@gmail.com");
        System.out.println("student= "+student);
    }
    @Test
    public  void printGetStudentsByEmailAddressNativeParam(){
    Student student=studentRepository.getStudentsByEmailAddressNativeParam("shivam@gmail.com");
        System.out.println("student= "+student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
    studentRepository.updateStudentNameByEmailId(
            "shweta Gupta",
            "shuhani@gmail.com"
    );
    }
}