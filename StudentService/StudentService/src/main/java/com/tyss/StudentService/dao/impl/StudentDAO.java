package com.tyss.StudentService.dao.impl;

import com.tyss.StudentService.dao.StudentDao;
import com.tyss.StudentService.entity.Student;
import com.tyss.StudentService.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
@Repository
public class StudentDAO implements StudentDao {

    private StudentRepo studentRepo;

    @Autowired
    public StudentDAO(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = studentRepo.findAll();
        if (!students.isEmpty()) {
            return students;
        }
        return null;
    }

    @Override
    public Student getStudentById(String studentId) {
        Optional<Student> student = studentRepo.findById(studentId);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }
}
