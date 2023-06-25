package com.example.student.mapper;

import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;

public class StudentMapper {
    public static Student toEntity(StudentDto studentDto) {
        return new Student(studentDto.getId(), studentDto.getName(), studentDto.getEmail(), studentDto.getBirth(), null);
    }

    public static StudentDto toDto(Student student) {
        return new StudentDto(student.getId(), student.getName(), student.getEmail(), student.getBirth());
    }
}
