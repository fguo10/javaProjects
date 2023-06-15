package com.example.student_demo.mapper;

import com.example.student_demo.dto.StudentDto;
import com.example.student_demo.entity.Student;

public class StudentMapper {
    public static Student toEntity(StudentDto studentDto) {
        return new Student(studentDto.getId(), studentDto.getName(), studentDto.getEmail(), studentDto.getBirth(), null);
    }

    public static StudentDto toDto(Student student) {
        return new StudentDto(student.getId(), student.getName(), student.getEmail(), student.getBirth());
    }
}
