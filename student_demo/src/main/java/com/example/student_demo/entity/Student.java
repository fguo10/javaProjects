package com.example.student_demo.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "student")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "stu", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
    private List<TeacherStudent> teacherStudentList = new ArrayList<>();


    public List<TeacherStudent> getTeacherStudentList() {
        return teacherStudentList;
    }

    public void setTeacherStudentList(List<TeacherStudent> ts) {
        this.teacherStudentList = ts;
    }

    public void addTeacherStudentList(TeacherStudent ts) {
        this.teacherStudentList.add(ts);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
