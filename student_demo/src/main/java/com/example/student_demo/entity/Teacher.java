package com.example.student_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "teacher")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<TeacherStudent> teacherStudentList;

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
        return "Teacher{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
