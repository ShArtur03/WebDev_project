//package ru.usatu.students.service;
//
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.stereotype.Service;
//import ru.usatu.students.model.Student;
//import ru.usatu.students.model.StudentList;
//
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.Unmarshaller;
//import java.io.File;
//import java.util.List;
//
////@Service
//@NoArgsConstructor
//@AllArgsConstructor
//public class StudentServiceXML implements StudentService{
//
//    private static final String FILE_PATH = "C:\\Users\\Student.ASU\\Downloads\\ИнетПрога\\students\\src\\main\\resources\\students.xml";
//    private static final File file = new File(FILE_PATH);
//
//    public List<Student> getStudents() throws Exception {
//        return getStudentList().getStudents();
//    }
//
//    public Student getStudent(int id) throws Exception {
//        return getStudents()
//                .stream().filter(student -> student.getId() == id)
//                .findFirst().orElse(new Student());
//    }
//
//    public Student addStudent(Student student) throws Exception {
//        StudentList studentList = getStudentList();
//        studentList.getStudents().add(student);
//        save(studentList);
//        return student;
//    }
//
//    public Student editStudent(int id, String name) throws Exception {
//        StudentList studentList = getStudentList();
//        Student neededStudent = studentList.getStudents()
//                .stream().filter(student -> student.getId() == id)
//                .findFirst().orElse(null);
//
//        if (neededStudent == null)
//            return new Student();
//
//        neededStudent.setName(name);
//        save(studentList);
//        return neededStudent;
//    }
//
//    public void deleteStudent(int id) throws Exception {
//        StudentList studentList = getStudentList();
//        Student neededStudent = studentList.getStudents()
//                .stream().filter(student -> student.getId() == id)
//                .findFirst().orElse(null);
//
//        if (neededStudent != null) {
//            studentList.getStudents().remove(neededStudent);
//            save(studentList);
//        }
//    }
//
//    //демаршаллинг файла - получение объекта в виде списка студентов
//    private StudentList getStudentList() throws Exception {
//        JAXBContext context = JAXBContext.newInstance(StudentList.class);
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        return (StudentList) unmarshaller.unmarshal(file);
//    }
//
//    //маршаллинг файла - сохранение нового студента
//    private void save(StudentList studentList) throws Exception {
//        JAXBContext context = JAXBContext.newInstance(StudentList.class);
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(studentList, file);
//    }
//}
