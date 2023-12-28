package com.tyss.StudentService.service.impl;

import com.tyss.StudentService.config.AddressService;
import com.tyss.StudentService.dao.StudentDao;
import com.tyss.StudentService.dto.Address;
import com.tyss.StudentService.dto.StudentRequest;
import com.tyss.StudentService.dto.StudentResponse;
import com.tyss.StudentService.entity.Student;
import com.tyss.StudentService.service.StudentService;
import com.tyss.StudentService.structure.ResponseStructure;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private ModelMapper modelMapper;

    private StudentDao studentDao;


    private AddressService addressService;

    @Autowired
    public StudentServiceImpl(ModelMapper modelMapper, StudentDao studentDao, AddressService addressService) {
        this.modelMapper = modelMapper;
        this.studentDao = studentDao;
        this.addressService = addressService;
    }

    @Override
    public ResponseEntity<ResponseStructure<StudentResponse>> saveStudent(StudentRequest studentRequest) {
        Student student = modelMapper.map(studentRequest, Student.class);
        Student student1 = studentDao.saveStudent(student);
        StudentResponse studentResponse = modelMapper.map(student1, StudentResponse.class);
        ResponseStructure<StudentResponse> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Success");
        structure.setData(studentResponse);
        return new ResponseEntity<ResponseStructure<StudentResponse>>(structure, HttpStatus.CREATED);


    }

    @Override
    public ResponseEntity<ResponseStructure<StudentResponse>> getStudentById(String studentId) {

        Student student = studentDao.getStudentById(studentId);
        StudentResponse studentResponse = modelMapper.map(student, StudentResponse.class);
        List<Address> addresses = addressService.getAddressByStudentRoll(student.getId()).getBody().getData();
        studentResponse.setAddresses(addresses);
        ResponseStructure<StudentResponse> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.CREATED.value());
        structure.setMessage("Success");
        structure.setData(studentResponse);

        return new ResponseEntity<ResponseStructure<StudentResponse>>(structure, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseStructure<List<StudentResponse>>> getAllStudent() {
        List<Student> students = studentDao.getAllStudent();
        List<StudentResponse> studentResponses = students.stream().map(student -> modelMapper.map(student, StudentResponse.class)).collect(Collectors.toList());
        List<StudentResponse> studentList = studentResponses.stream().map(student -> {
            student.setAddresses(addressService.getAddressByStudentRoll(student.getId()).getBody().getData());
            return student;
        }).collect(Collectors.toList());


        ResponseStructure<List<StudentResponse>> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(studentList);
        return new ResponseEntity<ResponseStructure<List<StudentResponse>>>(structure, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ResponseStructure<StudentResponse>> updateStudent(String studentId, String email) {
        Student student = studentDao.getStudentById(studentId);
        student.setEmail(email);
        Student student1 = studentDao.saveStudent(student);
        StudentResponse studentResponse = modelMapper.map(student1, StudentResponse.class);
        ResponseStructure<StudentResponse> structure = new ResponseStructure<>();
        structure.setStatusCode(HttpStatus.OK.value());
        structure.setMessage("Success");
        structure.setData(studentResponse);
        return new ResponseEntity<ResponseStructure<StudentResponse>>(structure, HttpStatus.OK);
    }
}
