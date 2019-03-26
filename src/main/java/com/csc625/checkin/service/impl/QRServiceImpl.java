package com.csc625.checkin.service.impl;

import com.amazonaws.util.IOUtils;
import com.csc625.checkin.model.dto.AccountDetailsDTO;
import com.csc625.checkin.model.pojo.QRCode;
import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.repository.QRRepository;
import com.csc625.checkin.repository.StudentRepository;
import com.csc625.checkin.repository.UserRepository;
import com.csc625.checkin.service.QRService;
import com.csc625.checkin.service.StudentService;
import com.csc625.checkin.service.UserService;
import javassist.bytecode.stackmap.TypeData.ClassName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
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

	public Boolean test() {
		LOGGER.info("getAllUsers service hit");
		String test = "";

		try {
			URL url = new URL("https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=BLAHBLAHALYSSA");

			//make connection
			URLConnection urlc = url.openConnection();

			//use post mode
			urlc.setDoOutput(true);
			urlc.setAllowUserInteraction(false);

			//send query
			PrintStream ps = new PrintStream(urlc.getOutputStream());
			ps.print("");
			ps.close();

			File targetFile = new File("C:\\\\Users\\\\Zehzen\\\\Desktop\\\\test.png");

			/*** WORKS SAVING A FILE
			java.nio.file.Files.copy(
					urlc.getInputStream(),
					targetFile.toPath(),
					StandardCopyOption.REPLACE_EXISTING);

			urlc.getInputStream().close();
			 **///

			byte[] contents = IOUtils.toByteArray(urlc.getInputStream());
			urlc.getInputStream().close();

			QRCode qrCode = new QRCode();
			//Blob blob = new javax.sql.rowset.serial.SerialBlob(contents);
			qrCode.setCode(contents);
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
	public QRCode getQRCode(String id) {
		LOGGER.info("getQRCode service hit...");
		return qrRepository.findOne(id);
	}

}
