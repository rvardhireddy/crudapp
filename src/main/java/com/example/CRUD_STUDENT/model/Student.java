package com.example.CRUD_STUDENT.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name="Student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String dob;
    @Column
    private String joiningdate;
    @Column
    private String classname;
}
