package ru.usatu.students.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.usatu.students.model.DTO.StudentDTO;
import ru.usatu.students.model.Student;
import ru.usatu.students.service.StudentService;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody StudentDTO student) throws Exception {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() throws Exception {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) throws Exception {
        return new ResponseEntity<>(studentService.editStudent(student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public HttpStatus deleteStudent(@PathVariable Long id) throws Exception {
        studentService.deleteStudent(id);
        return HttpStatus.OK;
    }
}
