package com.Prasun.Student_Management.Mapper;

import com.Prasun.Student_Management.DTO.StudentRequestDTO;
import com.Prasun.Student_Management.DTO.StudentResponseDTO;
import com.Prasun.Student_Management.Entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toEntity(StudentRequestDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        return student;
    }

    public StudentResponseDTO toDTO(Student student) {

        StudentResponseDTO dto = new StudentResponseDTO();

        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());

        return dto;
    }
}
