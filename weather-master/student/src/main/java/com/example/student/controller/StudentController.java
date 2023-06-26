package com.example.student.controller;

import com.example.student.dto.StudentDto;
import com.example.student.exception.StudentException;
import com.example.student.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "CRUD REST APIs for Student Resource", description = "CRUD REST APIs - Create Student, Update Student, Get Student, Get All Students, Delete Student")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("students")
public class StudentController {
    private StudentService studentService;


    @Operation(summary = "Create Student REST API", description = "Create Student REST API is used to save student in a database")
    @ApiResponse(responseCode = "201", description = "HTTP Status 201 CREATED")
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto savedStudentDto = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudentDto, HttpStatus.CREATED);
    }


    @Operation(summary = "Get all Students REST API", description = "Get all Students REST API is used to get all Students from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }


    @Operation(summary = "Get Student By ID REST API", description = "Get Student By ID REST API is used to get a single Student from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) throws StudentException {
        Optional<StudentDto> studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }


    @Operation(summary = "Update Student REST API", description = "Update Student REST API is used to update a particular Student in the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long id, @RequestBody StudentDto updatedStudentDto) throws Exception {
        return ResponseEntity.ok(studentService.updateStudent(id, updatedStudentDto));
    }


    @Operation(summary = "Delete Student REST API", description = "Delete Student REST API is used to delete a particular Student from the database")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 SUCCESS")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long id) throws Exception {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}
