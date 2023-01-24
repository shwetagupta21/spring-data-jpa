package com.springbootproject.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course") //because we are using FetchType.LAZY  and here we exclude course ,where we need we use FetchType.EAGER
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name="course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private long courseMaterialId;
    private String url;

    @OneToOne(
           cascade = CascadeType.ALL,
            //fetch= FetchType.EAGER
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name= "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

}
