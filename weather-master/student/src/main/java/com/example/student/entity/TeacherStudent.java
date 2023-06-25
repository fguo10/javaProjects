package com.example.student.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "TeacherStudent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_id")
    private Student stu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "t_id")
    private Teacher teacher;

    @Override
    public String toString() {
        return "TeacherStudent{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherStudent that = (TeacherStudent) o;
        return Objects.equals(id, that.id) && Objects.equals(stu, that.stu) && Objects.equals(teacher, that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stu, teacher);
    }
    
}
