package com.javacorner.admin.service;

import com.javacorner.admin.entity.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor loadInstructorById(Long instructorId);
    List<Instructor> findInstructorsByName(String name);
    Instructor loadInstructorsByEmail(String email);
    Instructor createInstructor(String firstName, String lastName, String summary, String email, String password);
    Instructor updateInstructor(Instructor instructorId);
    List<Instructor> fetchInstructors();
    void removeInstructor(Long instructorId);
}
