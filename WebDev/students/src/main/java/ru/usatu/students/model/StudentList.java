package ru.usatu.students.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "students")
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlAccessorType(XmlAccessType.FIELD)
public class StudentList {

    @XmlElement(name = "student")
    private List<Student> students;


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



}
