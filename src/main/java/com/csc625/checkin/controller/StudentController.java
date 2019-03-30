package com.csc625.checkin.controller;

import java.util.List;
import java.util.logging.Logger;

import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.service.StudentService;
import javassist.bytecode.stackmap.TypeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController 
{
    @Autowired
    private StudentService studentService;
    
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }
    
    private static final Logger LOGGER = 
                                    Logger.getLogger(TypeData.ClassName.class.getName());

    @RequestMapping(value = "/create-student", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student)
    {
    	LOGGER.info("Hit the add-student end point for user.");
        Student newStudent = studentService.addStudent(student);
        return newStudent;
    }
    
    @RequestMapping(value = "/find-linked/{uid}", method = RequestMethod.GET)
    public List<Student> findLinked(@PathVariable("uid") int userID)
    {	
    	LOGGER.info("Hit the findLinked end point.");
    	LOGGER.info("user - " + userID);
    	User user = new User();
    	user.setUserID(userID);
    	List<Student> students = studentService.findLinkedStudents(user);
        //LOGGER.info("Here is the student we found: " + students);
        return students;
    }

    @RequestMapping(value = "/get-student/{studentID}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable("studentID") int studentID)
    {
        LOGGER.info("Hit the getStudent end point:" + studentID);
        Student student = studentService.findStudent(studentID);
        return student;
    }

    @RequestMapping(value = "/get-student-by-name/{name}", method = RequestMethod.GET)
    public Student getStudentByName(@PathVariable("name") String name)
    {
        LOGGER.info("Hit the getStudentByName end point:" + name);
        Student student = studentService.findStudentByName(name);
        return student;
    }
    
}