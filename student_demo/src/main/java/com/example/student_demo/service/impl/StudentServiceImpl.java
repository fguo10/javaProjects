package com.example.student_demo.service.impl;

import com.example.student_demo.dto.StudentDto;
import com.example.student_demo.entity.Student;
import com.example.student_demo.mapper.StudentMapper;
import com.example.student_demo.repository.StudentRepository;
import com.example.student_demo.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        log.info("create student: " + studentDto.toString());
        Student savedStudent = studentRepository.save(StudentMapper.toEntity(studentDto));
        return StudentMapper.toDto(savedStudent);
    }
//
//    @Override
//    public StudentDto updateStudent(Long id, StudentDto updatedStudentDto) throws Exception {
//        log.info("update student: " + id + " " + updatedStudentDto.toString());
//        Optional<Student> student = studentRepository.findById(id);
//        Student updatedStudent = StudentMapper.toEntity(updatedStudentDto);
//        if (student.isPresent()) {
//            updatedStudent.setId(id);
//            return StudentMapper.toDto(studentRepository.save(updatedStudent));
//        } else {
//            log.error("can not find this  student, id = " + id);
//            throw new Exception("can not find this  student");
//        }
//    }
//
//    @Override
//    public List<StudentDto> getAllStudents() {
//        log.info("get all students...");
//        studentRepository.findAll().forEach(student -> StudentMapper.toDto(student));
//
//        return ;
//    }
//
//    @Override
//    public Optional<StudentDto> getStudentById(Long id) {
//        log.info("get student by Id, id = " + id);
//        return studentRepository.findById(id);
//    }
//
//    @Override
//    public void deleteStudent(Long id) throws Exception {
//        log.info("delete student: " + id);
//        Optional<Student> student = studentRepository.findById(id);
//        if (student.isPresent()) {
//            studentRepository.delete(student.get());
//            log.debug("delete student success, id = " + id);
//        } else {
//            log.error("can not find this  student, id = " + id);
//            throw new Exception("can not find this  student");
//        }
//    }
}
