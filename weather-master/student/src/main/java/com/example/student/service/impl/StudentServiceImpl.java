package com.example.student.service.impl;

import com.example.student.dto.StudentDto;
import com.example.student.entity.Student;
import com.example.student.exception.StudentException;
import com.example.student.mapper.StudentMapper;
import com.example.student.repository.StudentRepository;
import com.example.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        log.info("create student: " + studentDto.toString());
        Student savedStudent = studentRepository.save(StudentMapper.toEntity(studentDto));
        return StudentMapper.toDto(savedStudent);
    }

    @Override
    public List<StudentDto> getAllStudents(){
        log.info("get all students...");
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentMapper::toDto).collect(Collectors.toList());
    }


    @Override
    public Optional<StudentDto> getStudentById(Long id) throws StudentException {
        log.info("get student by Id, id = " + id);
        Optional<Student> student = studentRepository.findById(id);
        if (!student.isPresent()) {
            throw new StudentException("student not exist, id=" + id);
        }
        return student.map(StudentMapper::toDto);
    }


    @Override
    public StudentDto updateStudent(Long id, StudentDto updatedStudentDto) throws StudentException {
        log.info("Update student: " + id + " " + updatedStudentDto.toString());
        Optional<Student> existStudent = studentRepository.findById(id);
        if (!existStudent.isPresent()) {
            throw new StudentException("student not exist, id=" + id);
        }

        Student student = existStudent.get();
        student.setName(updatedStudentDto.getName());
        student.setEmail(updatedStudentDto.getEmail());
        student.setBirth(updatedStudentDto.getBirth());
        Student updatedStudent = studentRepository.save(student);
        return StudentMapper.toDto(updatedStudent);
    }

    @Override
    public void deleteStudent(Long id) throws StudentException {
        log.info("delete student: " + id);
        Optional<Student> existStudent = studentRepository.findById(id);
        if (!existStudent.isPresent()) {
            throw new StudentException("student not exist, id=" + id);
        }
        studentRepository.delete(existStudent.get());
    }
}
