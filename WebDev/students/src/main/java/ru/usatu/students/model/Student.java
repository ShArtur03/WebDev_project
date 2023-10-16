package ru.usatu.students.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @XmlElement(name = "id" )
    public Long id;

    @Column(name = "name")
    @XmlElement(name = "name")
    public String name;

    @Column(name = "age")
    public int age;

    @Column(name = "address")
    public String address;

    @Column(name = "direction")
    public String direction;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirection () {
        return direction ;
    }

    public void setDirection(String position) {
        this.direction  = direction ;
    }



    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object object){
        if (this == object)
            return true;

        if (object == null || getClass() != object.getClass())
            return false;

        Student student = (Student) object;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

