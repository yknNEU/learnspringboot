package com.ykn.spring.mapper;

import com.ykn.spring.dto.StudentDTO;
import com.ykn.spring.entity.Student;
import jakarta.annotation.Nonnull;

public class StudentMapper {

    @Nonnull
    public static StudentDTO mapToStudentDto(@Nonnull Student student) {
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );

    }

    @Nonnull
    public static Student mapToStudent(@Nonnull StudentDTO studentDto) {
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()
        );
    }

}
