package ru.habs.springstudents.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.Period;


@Data
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    @Column(unique=true)
    private String email;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
