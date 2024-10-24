package ru.habs.springstudents.Service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.habs.springstudents.Model.Student;
import ru.habs.springstudents.Repository.inMemoryStudentDAO;
import ru.habs.springstudents.Service.StudentService;

import java.util.List;

@Service
@AllArgsConstructor
public class inMemoryStudentServiceImpl implements StudentService {
    private final inMemoryStudentDAO repository;
    @Override
    public List<Student> findAllStudent() {
        return repository.findAllStudent();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public Boolean deleteStudent(String email) {
        repository.deleteStudent(email);
        return null;
    }
}