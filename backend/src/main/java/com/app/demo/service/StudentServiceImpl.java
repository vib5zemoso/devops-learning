package com.app.demo.service;

import com.app.demo.dto.StudentDto;
import com.app.demo.entity.Student;
import com.app.demo.exception.RecordNotFoundException;
import com.app.demo.repository.StudentRepository;
import com.app.demo.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = Converter.convertToEntity(studentDto, Student.class);
        Student createdStudent  = this.studentRepository.save(student);
        return Converter.convertToDTO(createdStudent, StudentDto.class);
    }

    @Override
    public StudentDto updateStudentById(StudentDto studentDto, Integer id) {
        Optional<Student> optionalStudent = Optional.ofNullable(this.studentRepository.findById(id).
                orElseThrow(() -> new RecordNotFoundException("Student id " + id)));
        if(optionalStudent.isPresent()){
            Student student = Converter.convertToEntity(studentDto, Student.class);
            student.setId(id);
            Student updatedStudent = this.studentRepository.save(student);
            return Converter.convertToDTO(updatedStudent, StudentDto.class);
        }
        return null;
    }

    @Override
    public StudentDto getStudentById(Integer id) {
        Optional<Student> optionalStudent = Optional.ofNullable(this.studentRepository.findById(id).
                orElseThrow(() -> new RecordNotFoundException("Student id " + id)));
        if(optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            return Converter.convertToDTO(student, StudentDto.class);
        }
        return null;
    }

    @Override
    public void deleteStudentById(Integer id) {
        Optional<Student> optionalStudent = Optional.ofNullable(this.studentRepository.findById(id).
                orElseThrow(() -> new RecordNotFoundException("Student id " + id)));
        if(optionalStudent.isPresent()){
            studentRepository.deleteById(id);
        }
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = this.studentRepository.findAll();
        List<StudentDto> studentsDto = students.stream().map(student -> Converter.convertToDTO(student, StudentDto.class)).collect(Collectors.toList());
        return studentsDto;
    }
}