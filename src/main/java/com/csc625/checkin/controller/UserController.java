package com.csc625.checkin.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.service.UserService;

import javassist.bytecode.stackmap.TypeData.ClassName;

@RestController
public class UserController {
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@Autowired
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	/*@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public User addUser(@RequestBody AccountDetailsDTO accountDetails, HttpServletResponse response) {
		LOGGER.info("Add user controller hit.");
		User newUser = userService.addUser(accountDetails);
		return newUser;
	}*/
	
    @RequestMapping(value = "/get-user/{uid}", method = RequestMethod.GET)
    public User getUser(@PathVariable("uid") String uid)
    {
        LOGGER.info("getUser endpoint hit find uid " + uid);
        User user = userService.getUserByUID(uid);
        return user;
    }
    
    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public List<User> allUsers()
    {
        LOGGER.info("allUsers endpoint hit");
        List<User> users = userService.getAllUsers();
        return users;
    }
}
