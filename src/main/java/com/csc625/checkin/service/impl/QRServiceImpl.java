package com.csc625.checkin.service.impl;

import com.amazonaws.util.IOUtils;
import com.csc625.checkin.model.pojo.QRCode;
import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.repository.QRRepository;
import com.csc625.checkin.service.QRService;
import com.csc625.checkin.service.StudentService;
import javassist.bytecode.stackmap.TypeData.ClassName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service ("qRService")
public class QRServiceImpl implements QRService {
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());
	
	@Autowired
	private StudentService studentService;

	@Autowired
	@Qualifier("QRRepository")
	private QRRepository qrRepository;


	@Override
	public List <QRCode> getAllQRCodes() {
		LOGGER.info("Get all qrCodes service hit...");
		List<QRCode> qrCodes = (List<QRCode>) qrRepository.findAll();
		return qrCodes;
	}

	public Boolean createQRCode(Student student) {
		LOGGER.info("createQRCode service hit");
		String test = "";

		try {
			String codeValue = student.getStudentFirstName() + student.getStudentLastName();
			URL url = new URL("https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=" + codeValue);

			//make connection
			URLConnection urlc = url.openConnection();

			//use post mode
			urlc.setDoOutput(true);
			urlc.setAllowUserInteraction(false);

			//send query
			PrintStream ps = new PrintStream(urlc.getOutputStream());
			ps.print("");
			ps.close();

			byte[] contents = IOUtils.toByteArray(urlc.getInputStream());
			urlc.getInputStream().close();

			QRCode qrCode = new QRCode();
			qrCode.setCode(contents);
			qrCode.setStudent(student);
			qrRepository.save(qrCode);


		}catch(Exception e) {
			LOGGER.info("exception in test QR service");
		}

		return true;
	}

	@Override
	public QRCode addQRCode(QRCode qrCode) {
		LOGGER.info("Log user login service hit...");
		return null;
	}

	@Override
	public List<QRCode> getQRCode(String id) {
		LOGGER.info("getQRCode service hit...");
		List<QRCode> codes = new ArrayList<QRCode>();
		codes.add(qrRepository.findOne(id));
		return codes;
	}

}
