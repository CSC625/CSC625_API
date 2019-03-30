package com.csc625.checkin.service.impl;

import java.util.List;
import java.util.logging.Logger;

import com.csc625.checkin.model.dto.AccountDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.repository.StudentRepository;
import com.csc625.checkin.repository.UserRepository;
import com.csc625.checkin.service.StudentService;
import com.csc625.checkin.service.UserService;

import javassist.bytecode.stackmap.TypeData.ClassName;

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
