package com.tyss.StudentService.service;

import com.tyss.StudentService.dto.StudentRequest;
import com.tyss.StudentService.dto.StudentResponse;
import com.tyss.StudentService.structure.ResponseStructure;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    ResponseEntity<ResponseStructure<StudentResponse>> saveStudent(StudentRequest studentRequest);

    ResponseEntity<ResponseStructure<StudentResponse>> getStudentById(String studentId);

    ResponseEntity<ResponseStructure<List<StudentResponse>>> getAllStudent();

    ResponseEntity<ResponseStructure<StudentResponse>> updateStudent(String studentId, String email);
}
