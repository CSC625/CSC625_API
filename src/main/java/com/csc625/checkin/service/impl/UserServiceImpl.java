package com.csc625.checkin.service.impl;

import java.util.List;
import java.util.logging.Logger;

import com.csc625.checkin.model.dto.AccountDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc625.checkin.exceptions.NotFoundException;
import com.csc625.checkin.model.dto.AccountLinkStudentDTO;
import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.repository.StudentRepository;
import com.csc625.checkin.repository.UserRepository;
import com.csc625.checkin.service.StudentService;
import com.csc625.checkin.service.UserService;

import javassist.bytecode.stackmap.TypeData.ClassName;

import com.csc625.checkin.utils.Constants;

@Service ("userService")
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@Override
	public User addUser(AccountDetailsDTO accountDetails) {
		LOGGER.info("Adding user service hit...");
		User u = userRepository.save(accountDetails.getUser());
		
		/*if(u.getUid() != null){
			accountDetails.setUser(u);
			
			LOGGER.info("LOOK HERE FOR THE ROLE" + u.getRole().getName());
			switch(u.getRole().getName()){
				case Constants.ROLE_STUDENT: {
					Student student = new Student();
					student.setStudentFirstName(accountDetails.getFirstName());
					student.setStudentLastName(accountDetails.getLastName());
					student.setDateOfBirth(accountDetails.getDob());
					
					Student existingStudent = null;
					try{
						existingStudent = studentService.getStudent(student);
					} catch(NotFoundException ex){
						LOGGER.info("This Student has not been added by any Teachers.");
						Student newStudent = studentRepository.save(student);
						AccountLinkStudentDTO accountLinkStudent = new AccountLinkStudentDTO();
						accountLinkStudent.setStudentID(newStudent.getStudentId());
						accountLinkStudent.setUserID(u.getUserID());
						studentRepository.linkStudent(accountLinkStudent);
						
					}
					
					if(existingStudent != null){
						LOGGER.info("This Student has already been added by a Teacher. We can link them to their preexsiting account.");
						AccountLinkStudentDTO accountLinkStudent = new AccountLinkStudentDTO();
						accountLinkStudent.setStudentID(existingStudent.getStudentId());
						accountLinkStudent.setUserID(u.getUserID());
						studentRepository.linkStudent(accountLinkStudent);
					}
					
					break;
					

				}
			}
		}*/
		
		return u;
	}

	@Override
	public User getUserByUID(String uid) {
		LOGGER.info("Get user service hit...");
		User u = userRepository.findOne(uid);
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		LOGGER.info("getAllUsers service hit");
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}

	@Override
	public Boolean logUserLogin(String uid) {
		LOGGER.info("Log user login service hit...");
		return true;
	}

}
