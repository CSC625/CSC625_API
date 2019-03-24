package com.csc625.checkin.controller;

import com.csc625.checkin.database.tables.Qrcode;
import com.csc625.checkin.model.dto.AccountDetailsDTO;
import com.csc625.checkin.model.pojo.QRCode;
import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.service.QRService;
import com.csc625.checkin.service.UserService;
import javassist.bytecode.stackmap.TypeData.ClassName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class QRController {
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@Autowired
	private QRService qrService;

	public QRController(QRService qrService) {
		this.qrService = qrService;
	}

    @RequestMapping(value = "/get-qr-code/{text}", method = RequestMethod.GET)
    public QRCode getCode(@PathVariable("text") String text)
    {
        LOGGER.info("getCode endpoint hit find uid " + text);
        qrService.test();
        return null;
    }

	/*@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public User addUser(@RequestBody AccountDetailsDTO accountDetails, HttpServletResponse response) {
		LOGGER.info("Add user controller hit.");
		User newUser = userService.addUser(accountDetails);
		return newUser;
	}
    
    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public List<User> allUsers()
    {
        LOGGER.info("allUsers endpoint hit");
        List<User> users = userService.getAllUsers();
        return users;
    }

    @RequestMapping(value = "/log-user-login", method = RequestMethod.GET)
    public Boolean logUserLogin(@PathVariable("uid") String uid)
    {
        LOGGER.info("allUsers endpoint hit");
        return userService.logUserLogin(uid);
    }*/
}
