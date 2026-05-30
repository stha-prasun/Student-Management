package com.Prasun.Student_Management.Service.impl;

import com.Prasun.Student_Management.DTO.StudentRequestDTO;
import com.Prasun.Student_Management.DTO.StudentResponseDTO;
import com.Prasun.Student_Management.Entity.Student;
import com.Prasun.Student_Management.Mapper.StudentMapper;
import com.Prasun.Student_Management.Repository.StudentRepository;
import com.Prasun.Student_Management.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentMapper mapper;

    @Override
    public StudentResponseDTO saveStudent(StudentRequestDTO dto){
        Student student = mapper.toEntity(dto);

        Student savedStudent = repository.save(student);

        return mapper.toDTO(savedStudent);

    }

    @Override
    public List<StudentResponseDTO> getAllStudents(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public StudentResponseDTO getStudentById(Long id){
        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Student not found"));

        return mapper.toDTO(student);
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto){
        Student student = repository.findById(id)
                .orElseThrow(()-> new RuntimeException(
                        "Not Found"
                ));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setAge(dto.getAge());

        Student updated = repository.save(student);

        return mapper.toDTO(updated);
    }
}
