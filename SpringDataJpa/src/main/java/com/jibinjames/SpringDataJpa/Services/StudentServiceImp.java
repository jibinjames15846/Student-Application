package com.jibinjames.SpringDataJpa.Services;

import com.jibinjames.SpringDataJpa.Models.Student;
import com.jibinjames.SpringDataJpa.Repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    Logger logger = LoggerFactory.getLogger("StudentServiceImpl");

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);

    }

    @Override
    public void deleteStudentById(Long sid) {
        studentRepository.deleteById(sid);

    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> studentList = (List<Student>) studentRepository.findAll();
        logger.info("Student List from the Db ()" + studentList);
        return studentList;
    }

    @Override
    public Student getStudentByName(Long sid) {
        Student student = studentRepository.findById(sid).get();
        logger.info("Getting student with name " + student.getName());
        return student;
    }

    @Override
    public String updateStudent(Long sid, String address) {
        studentRepository.updateAddress(sid,address);
        return  " New Address for Student with Id " +sid+ " Is "+address;
    }
}
