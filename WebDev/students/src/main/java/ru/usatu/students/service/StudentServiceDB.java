package ru.usatu.students.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.usatu.students.model.DTO.StudentDTO;
import ru.usatu.students.model.Student;
import ru.usatu.students.repository.StudentRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceDB implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public Student addStudent(StudentDTO studentDTO) {
        return studentRepository.save(Student.builder()
                .name(studentDTO.getName())
                .age(studentDTO.getAge())
                .address(studentDTO.getAddress())
                .direction(studentDTO.getDirection())
                .build());
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository
                .findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository
                .findById(id)
                .orElse(new Student());
    }

    @Override
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
