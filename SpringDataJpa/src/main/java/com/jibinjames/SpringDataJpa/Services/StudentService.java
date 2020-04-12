package com.jibinjames.SpringDataJpa.Services;

import com.jibinjames.SpringDataJpa.Models.Student;

import java.util.List;

public interface StudentService {
    
    void addStudent(Student student);

    void deleteStudentById(Long sid);

    List<Student> findAllStudents();

    Student getStudentByName(Long sid);

    String updateStudent(Long sid, String address);
}
