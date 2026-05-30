package com.Prasun.Student_Management.Controller;

import com.Prasun.Student_Management.DTO.StudentRequestDTO;
import com.Prasun.Student_Management.DTO.StudentResponseDTO;
import com.Prasun.Student_Management.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;

    @PostMapping
    public StudentResponseDTO save(@RequestBody StudentRequestDTO dto){
        return service.saveStudent(dto);
    }

    @GetMapping
    public List<StudentResponseDTO> getAll(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentResponseDTO getStudentById(@PathVariable Long id){
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentResponseDTO updateStudent(@PathVariable Long id, @RequestBody StudentRequestDTO dto){
        return service.updateStudent(id, dto);
    }
}
