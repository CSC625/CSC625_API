package com.csc625.checkin.controller;

import com.csc625.checkin.model.dto.AccountDetailsDTO;
import com.csc625.checkin.model.pojo.CheckIn;
import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.service.CheckInService;
import com.csc625.checkin.service.UserService;
import javassist.bytecode.stackmap.TypeData.ClassName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class CheckInController {
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@Autowired
	private CheckInService checkInService;

	public CheckInController(CheckInService checkInService) {
		this.checkInService = checkInService;
	}

	@RequestMapping(value = "/log-checkin/{qrText}", method = RequestMethod.POST)
	public CheckIn logCheckIn(@PathVariable("qrText") String qrText) {
		LOGGER.info("logCheckIn endpoint hit.");
		CheckIn newCheckIn = checkInService.logCheckIn(qrText);
		return newCheckIn;
	}
    
    @RequestMapping(value = "/all-checkins", method = RequestMethod.GET)
    public List<CheckIn> allUsers()
    {
        LOGGER.info("allcheckins endpoint hit");
        List<CheckIn> checkIns = checkInService.getAllCheckIns();
        return checkIns;
    }

}

