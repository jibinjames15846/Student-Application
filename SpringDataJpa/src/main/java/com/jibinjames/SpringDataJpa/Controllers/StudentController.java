package com.jibinjames.SpringDataJpa.Controllers;
import com.jibinjames.SpringDataJpa.Models.Student;
import com.jibinjames.SpringDataJpa.Services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController  // Instead of @RestController we can use @Controller and @ResponseBody annotations otherwise if we use @Controller annotation only we will get some View Error
public class StudentController {

    Logger logger = LoggerFactory.getLogger("SudentApp");

    @Autowired
    private StudentService studentService;


    @PostMapping("/student")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        URI path = ServletUriComponentsBuilder
                .fromCurrentRequest().path("{/sid}")
                .buildAndExpand(student.getSid()).toUri();
        return ResponseEntity.created(path).build();

    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        logger.info("Getting All students ");
        return  studentService.findAllStudents();

    }

    @GetMapping("/studet/{sid}")
    public  Student getStudent(@PathVariable Long sid)
    {
        logger.info("Getting Student With Id "+sid);
        return  studentService.getStudentByName(sid);

    }

    @PutMapping("/student/{sid}")
    public String updateStudent(@PathVariable Long sid , @RequestParam String address)
    {
        logger.info("The sid is "+sid);
        return  studentService.updateStudent(sid,address);


    }

    @DeleteMapping("/student/{sid}")
    public String deleteStudent(@PathVariable Long sid)
    {
      studentService.deleteStudentById(new Long(sid));
      return " Student deleted with "+sid+ " Successfully";

    }


}
