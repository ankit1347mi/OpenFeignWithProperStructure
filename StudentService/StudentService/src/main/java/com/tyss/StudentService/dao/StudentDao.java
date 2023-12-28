package com.tyss.StudentService.dao;

import com.tyss.StudentService.entity.Student;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentDao {

    Student saveStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(String studentId);
}
