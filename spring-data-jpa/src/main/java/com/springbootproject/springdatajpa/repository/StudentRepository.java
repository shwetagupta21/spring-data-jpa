package com.springbootproject.springdatajpa.repository;

import com.springbootproject.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student,Long> {
    public List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastName(String lastName);

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName,
                                       String lastName);


    @Query("select s from Student  s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student  s where s.emailId=?1")
    String getStudentByFirstNameByEmailAddress(String emailId);

    //Native
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address =?1",
            nativeQuery = true
    )
    Student getStudentByFirstNameByEmailAddressNative(String emailId);


    //Native Named Param  --for complex data
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address= :emailId",
            nativeQuery = true
    )
    Student getStudentsByEmailAddressNativeParam(
            @Param("emailId") String emailId
    );

    @Modifying //for modify the data
    @Transactional

    @Query(
            value  ="update tbl_student set first_name=?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);

}
