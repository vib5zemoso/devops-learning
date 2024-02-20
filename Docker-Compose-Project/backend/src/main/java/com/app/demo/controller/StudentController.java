package com.app.demo.controller;

import com.app.demo.dto.StudentDto;
import com.app.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto createdStudent = this.studentService.createStudent(studentDto);
        return new ResponseEntity<StudentDto>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@RequestBody StudentDto studentDto, @PathVariable Integer id) {
        StudentDto updatedStudent = this.studentService.updateStudentById(studentDto,id);
        return new ResponseEntity<StudentDto>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Integer id) {
        this.studentService.deleteStudentById(id);
        return new ResponseEntity("Student Deleted", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Integer id) {
        StudentDto studentDto = this.studentService.getStudentById(id);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return new ResponseEntity<List<StudentDto>>(this.studentService.getAllStudent(), HttpStatus.OK);
    }
}