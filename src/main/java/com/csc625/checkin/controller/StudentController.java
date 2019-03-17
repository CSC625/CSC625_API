package com.csc625.checkin.controller;

import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StudentController 
{
    /*@Autowired
    private StudentService studentService;
    
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }
    
    private static final Logger LOGGER = 
                                    Logger.getLogger(ClassName.class.getName());
    
    @RequestMapping(value = "/all-students", method = RequestMethod.GET)
    public List<Student> allStudents()
    {
        LOGGER.info("allStudents endpoint hit");
        List<Student> students = studentService.getAllStudents();
        return students;
    }
    
    @RequestMapping(value = "/get-student/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") String id)
    {
        LOGGER.info("getStudentById endpoint hit find id" + id);
        Student student = studentService.getStudentById(id);
        return student;
    }
    @RequestMapping(value = "/create-student", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student)
    {
    	LOGGER.info("Hit the add-student end point.");
        Student newStudent = studentService.addStudent(student);
        return newStudent;
    }
    
    @RequestMapping(value = "/get-student", method = RequestMethod.POST)
    public Student getStudent(@RequestBody StudentDTO studentDto)
    {	
    	LOGGER.info("Hit the get-student end point.");
        Student foundStudent = studentService.getStudent(studentDto);
        LOGGER.info("Here is the student we found: " + foundStudent);
        return foundStudent;
    }
    
    @RequestMapping(value = "/link-student", method = RequestMethod.POST)
    public AccountLinkStudent linkStudent(@RequestBody AccountLinkStudentDTO accountLinkDto)
    {	
    	LOGGER.info("Hit the link-student end point.");
        
    	AccountLinkStudent accountLink = studentService.linkStudent(accountLinkDto);
        return accountLink;
    }
    
    @RequestMapping(value = "/find-linked/{uid}", method = RequestMethod.GET)
    public List<Student> findLinked(@PathVariable("uid") int userID)
    {	
    	LOGGER.info("Hit the get-student end point.");
    	LOGGER.info("user - " + userID);
    	User user = new User();
    	user.setUserID(userID);
    	List<Student> students = studentService.findLinkedStudents(user);
        //LOGGER.info("Here is the student we found: " + students);
        return students;
    }*/
    
}