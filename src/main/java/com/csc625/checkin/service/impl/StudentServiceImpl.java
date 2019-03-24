package com.csc625.checkin.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc625.checkin.exceptions.NotFoundException;
import com.csc625.checkin.model.dto.AccountLinkStudentDTO;
import com.csc625.checkin.model.dto.StudentDTO;
import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.repository.StudentRepository;
import com.csc625.checkin.service.StudentService;

@Service ("studentService")
public class StudentServiceImpl implements StudentService
{
    private static final Logger LOGGER =
                                    Logger.getLogger(ClassName.class.getName());
    
    @Autowired
    private StudentRepository studentRepository;
    
    public List<Student> getAllStudents() 
    {
        LOGGER.info("getAllStudents service hit");
        List<Student> students = (List<Student>) studentRepository.findAll();
        return students;
    }

    public Student getStudentById(String Id) 
    {
        Student student = studentRepository.findOne(Id);
        return student;
    }   
    
    public Student addStudent(Student student) 
    {
        Student newStudent = studentRepository.save(student);

        //create new QR code for student

        return newStudent;
    }
    
    public Student getStudent(StudentDTO studentDto)
    {
        Student student  = studentRepository.findStudent(studentDto);
        if(student == null){
        	throw new NotFoundException("Could not find the student with those search parameters.");
        }
        return student;
    }
    
    public Student getStudent(Student student)
    {	
    	StudentDTO s = new StudentDTO();
    	s.setFirstName(student.getStudentFirstName());
    	s.setLastName(student.getStudentLastName());
        Student rs  = studentRepository.findStudent(s);
        if(rs  == null){
        	throw new NotFoundException("Could not find the student with those search parameters.");
        }
        return rs ;
    }

    public List <Student> findLinkedStudents(User user)
    {
        List<Student> students = (List<Student>) studentRepository.findLinkedStudents(user.getUserID());
        return students;
    }
}