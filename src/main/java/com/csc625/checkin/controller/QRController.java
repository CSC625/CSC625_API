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
        //qrService.createQRCode();
        return null;
    }

    @RequestMapping(value = "/get-qr-code-single/{id}", method = RequestMethod.GET)
    public List<QRCode> getCodeSingle(@PathVariable("id") int id)
    {
        LOGGER.info("getCodeSingle endpoint hit find uid " + id);
        return qrService.getQRCode(String.valueOf(id));
    }

    @RequestMapping(value = "/all-qr-codes", method = RequestMethod.GET)
    public List<QRCode> allQRCodes()
    {
        LOGGER.info("allQRCodes endpoint hit");
        List<QRCode> qrCodes = qrService.getAllQRCodes();
        return qrCodes;
    }

	/*@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public User addUser(@RequestBody AccountDetailsDTO accountDetails, HttpServletResponse response) {
		LOGGER.info("Add user controller hit.");
		User newUser = userService.addUser(accountDetails);
		return newUser;
	}
    


    @RequestMapping(value = "/log-user-login", method = RequestMethod.GET)
    public Boolean logUserLogin(@PathVariable("uid") String uid)
    {
        LOGGER.info("allUsers endpoint hit");
        return userService.logUserLogin(uid);
    }*/
}

