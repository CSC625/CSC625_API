package com.csc625.checkin.repository;

import java.util.List;

import com.csc625.checkin.model.dto.StudentDTO;
import com.csc625.checkin.model.pojo.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String>
{
    List<Student> findById(String Id);
	Student findStudent(StudentDTO studentDto);
    List<Student> findLinkedStudents(int userID);
}
