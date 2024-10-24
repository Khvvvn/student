package ru.habs.springstudents.Service;

import ru.habs.springstudents.Model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    Student saveStudent(Student student);
    Student findByEmail(String email);
    Student updateStudent(Student student);
    Boolean deleteStudent(String email);
}
