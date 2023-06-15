package com.example.student_demo.controller;

import com.example.student_demo.dto.StudentDto;
import com.example.student_demo.entity.Student;
import com.example.student_demo.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("students")
public class StudentController {
    private StudentService studentService;

//    @GetMapping
//    public ResponseEntity<List<Student>> getAllStudents() {
//        return ResponseEntity.ok(studentService.getAllStudents());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id) {
//        Optional<Student> student = studentService.getStudentById(id);
//        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//    }
//
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto savedStudentDto = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudentDto, HttpStatus.CREATED);
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student updatedStudent) throws Exception {
//        return ResponseEntity.ok(studentService.updateStudent(id, updatedStudent));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long id) throws Exception {
//        studentService.deleteStudent(id);
//        return ResponseEntity.ok("delete student success");
//    }

}
