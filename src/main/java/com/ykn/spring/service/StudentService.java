package com.ykn.spring.service;

import com.ykn.spring.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDto);

    StudentDTO getStudentById(Long studentId);

    List<StudentDTO> getAllStudents();

    StudentDTO updateStudent(Long studentId, StudentDTO updatedStudent);

    void deleteStudent(Long studentId);
}
