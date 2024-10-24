package ru.habs.springstudents.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.habs.springstudents.Model.*;
import ru.habs.springstudents.Service.StudentService;
import java.util.List;



@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;
    @GetMapping
    public List<Student> findAllStudent()
    {
        return studentService.findAllStudent();
    }

    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "Student succefully saved";
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email) {
        return studentService.findByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public ResponseEntity<String> deleteStudent(@PathVariable String email) {
        Boolean isDeleted = studentService.deleteStudent(email);
        if (isDeleted) {
            return ResponseEntity.ok("Студент с email " + email + " был успешно удален.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Студент с email " + email + " не найден.");
        }
    }

}
