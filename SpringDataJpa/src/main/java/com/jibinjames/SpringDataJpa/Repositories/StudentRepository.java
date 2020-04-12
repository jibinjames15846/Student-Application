package com.jibinjames.SpringDataJpa.Repositories;
import com.jibinjames.SpringDataJpa.Models.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface StudentRepository extends CrudRepository <Student,Long> {

   // @Query("select s from Student s  where s.place = ?1 ")
   // List<Student> getAllStudentByPlace(String place);


    @Transactional
    @Modifying
    @Query("update Student set address =:address where sid = :sid")
    void updateAddress(@Param("sid") Long sid, @Param("address") String address);
}
