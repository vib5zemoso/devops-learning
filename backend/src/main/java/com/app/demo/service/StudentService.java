package com.app.demo.service;

import com.app.demo.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto updateStudentById(StudentDto studentDto, Integer id);
    StudentDto getStudentById(Integer id);
    void deleteStudentById(Integer id);
    List<StudentDto> getAllStudent();
}