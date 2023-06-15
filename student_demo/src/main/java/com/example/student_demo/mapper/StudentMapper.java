package com.example.student_demo.mapper;

import com.example.student_demo.dto.StudentDto;
import com.example.student_demo.entity.Student;

public class StudentMapper {
    public static Student toEntity(StudentDto studentDto){
        return new Student(studentDto.getId(), studentDto.getName(), null);
    }

    public static StudentDto toDto(Student student){
        return new StudentDto(student.getId(), student.getName());
    }
}
