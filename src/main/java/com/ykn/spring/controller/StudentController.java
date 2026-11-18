package com.ykn.spring.controller;

import com.ykn.spring.dto.StudentDTO;
import com.ykn.spring.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDto) {
        StudentDTO savedStudentDto = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudentDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable("id") Long studentId) {
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentDTO studentDto) {
        return ResponseEntity.ok(studentService.updateStudent(studentId, studentDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
