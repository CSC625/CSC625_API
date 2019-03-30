package com.csc625.checkin.service.impl;

import com.csc625.checkin.model.pojo.CheckIn;
import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.repository.CheckInRepository;
import com.csc625.checkin.repository.StudentRepository;
import com.csc625.checkin.service.CheckInService;
import javassist.bytecode.stackmap.TypeData.ClassName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service ("checkInService")
public class CheckInServiceImpl implements CheckInService {
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@Autowired
	private CheckInRepository checkInRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public CheckIn logCheckIn(String codeText) {
		LOGGER.info("logCheckIn service hit...");
		Student student = studentRepository.findStudentByName(codeText);
		CheckIn checkIn = new CheckIn(student);
		CheckIn c = checkInRepository.save(checkIn);
		return c;
	}

	@Override
	public List<CheckIn> getAllCheckIns() {
		LOGGER.info("getAllCheckIns service hit");
		List<CheckIn> checkIns = (List<CheckIn>) checkInRepository.findAll();
		return checkIns;
	}

}
