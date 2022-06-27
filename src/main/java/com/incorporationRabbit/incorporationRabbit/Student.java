package com.incorporationRabbit.incorporationRabbit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


//new - can get rid of
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "Id", scope = Student.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1 //increment
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(
            name = "id",
            updatable = false //no one can update it

    )
    private int id;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column (unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private int age;

//    private String address;


    public Student(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

}
