package com.example.student_demo.service;

import com.example.student_demo.dto.StudentDto;
import com.example.student_demo.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);

    List<StudentDto> getAllStudents();

    Optional<StudentDto> getStudentById(Long id);

//    StudentDto updateStudent(Long id, StudentDto updatedStudentDto) throws Exception;


//
//
//    void deleteStudent(Long id) throws Exception;
}
