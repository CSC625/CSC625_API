package com.csc625.checkin.service;

import java.util.List;

import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.model.pojo.User;

public interface StudentService 
{
    List <Student> getAllStudents();
    Student addStudent(Student student);
    List <Student> findLinkedStudents(User user);
    Student findStudent(int studentID);
    Student findStudentByName(String name);
}
