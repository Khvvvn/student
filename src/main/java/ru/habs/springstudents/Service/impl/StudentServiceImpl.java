package ru.habs.springstudents.Service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.habs.springstudents.Model.Student;
import ru.habs.springstudents.Repository.StudentRepository;
import ru.habs.springstudents.Service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }


    @Override
    @Transactional
    public Boolean deleteStudent(String email) {
        // Находим студента по email
        Student student = studentRepository.findByEmail(email);

        // Если студент найден, удаляем его и возвращаем true
        if (student != null) {
            studentRepository.delete(student);
            return true; // Студент был успешно удален
        }

        // Если студент не найден, возвращаем false
        return false; // Студент не найден
    }

}
