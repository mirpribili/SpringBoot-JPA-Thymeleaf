package com.javacorner.admin.service;

import com.javacorner.admin.entity.Student;

import java.util.List;

public interface StudentService {
    Student loadStudentById(Long studentId);
    List<Student> findStudentByName(String name);
    Student loadStudentByEmail(String email);

    Student createStudent(String firstName, String lastName,String level, String email, String password);
    Student updateStudent(Student student);
    List<Student> fetchStudent();
    void removeStudent(Long studentId);
}
