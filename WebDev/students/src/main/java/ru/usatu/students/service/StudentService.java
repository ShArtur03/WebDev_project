package ru.usatu.students.service;

import ru.usatu.students.model.DTO.StudentDTO;
import ru.usatu.students.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(StudentDTO studentDTO) throws Exception;

    List<Student> getStudents() throws Exception;

    Student getStudent(Long id) throws Exception;

    Student editStudent(Student student) throws Exception;

    void deleteStudent(Long id) throws Exception;
}
