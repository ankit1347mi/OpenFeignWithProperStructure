package com.tyss.StudentService.controller;

import com.tyss.StudentService.dto.StudentRequest;
import com.tyss.StudentService.dto.StudentResponse;
import com.tyss.StudentService.service.StudentService;
import com.tyss.StudentService.structure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<StudentResponse>> saveStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<ResponseStructure<StudentResponse>> getStudentById(@PathVariable String studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<StudentResponse>>> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PatchMapping("/{studentId}/{email}")
    public ResponseEntity<ResponseStructure<StudentResponse>> updateStudent(@PathVariable String studentId, @PathVariable String email) {
        return studentService.updateStudent(studentId, email);
    }
}
