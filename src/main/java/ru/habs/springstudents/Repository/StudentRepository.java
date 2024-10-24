package ru.habs.springstudents.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.habs.springstudents.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    void deleteByEmail(String email);
    Student findByEmail(String email);
}
