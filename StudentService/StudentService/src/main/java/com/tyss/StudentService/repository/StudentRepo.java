package com.tyss.StudentService.repository;

import com.tyss.StudentService.entity.Student;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String> {
}
