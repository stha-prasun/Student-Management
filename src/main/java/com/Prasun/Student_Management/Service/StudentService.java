package com.Prasun.Student_Management.Service;

import com.Prasun.Student_Management.DTO.StudentRequestDTO;
import com.Prasun.Student_Management.DTO.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    StudentResponseDTO saveStudent(StudentRequestDTO dto);

    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO getStudentById(Long id);

    StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto);

    void deleteStudent(Long id);
}
