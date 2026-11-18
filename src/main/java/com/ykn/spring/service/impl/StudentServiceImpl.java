package com.ykn.spring.service.impl;

import com.ykn.spring.dto.StudentDTO;
import com.ykn.spring.entity.Student;
import com.ykn.spring.exception.ResourceNotFoundException;
import com.ykn.spring.mapper.StudentMapper;
import com.ykn.spring.repository.StudentRepository;
import com.ykn.spring.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentDTO createStudent(StudentDTO studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDTO getStudentById(Long studentId) {
        return StudentMapper.mapToStudentDto(
                studentRepository.findById(studentId).orElseThrow(
                        () -> new ResourceNotFoundException("Student ID " + studentId + " does not exist.")
                )
        );
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(StudentMapper::mapToStudentDto).collect(Collectors.toList());
    }

    @Override
    public StudentDTO updateStudent(Long studentId, StudentDTO updatedStudent) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student ID " + studentId + " does not exist.")
        );

        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());

        Student updated = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(updated);
    }

    @Override
    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student ID " + studentId + " does not exist.")
        );

        studentRepository.deleteById(student.getId());
    }
}
