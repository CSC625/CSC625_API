package com.csc625.checkin.service.impl;

import com.csc625.checkin.model.dto.AccountDetailsDTO;
import com.csc625.checkin.model.pojo.QRCode;
import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.repository.StudentRepository;
import com.csc625.checkin.repository.UserRepository;
import com.csc625.checkin.service.QRService;
import com.csc625.checkin.service.StudentService;
import com.csc625.checkin.service.UserService;
import javassist.bytecode.stackmap.TypeData.ClassName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Logger;

@Service ("qrService")
public class QRServiceImpl implements QRService {
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;


	@Override
	public List <QRCode> getAllQRCodes() {
		//LOGGER.info("Get user service hit...");
		//User u = userRepository.findOne(uid);
		return null;
	}

	public Boolean test() {
		LOGGER.info("getAllUsers service hit");
		String test = "";

		try {
			URL url = new URL("https://api.qrserver.com/v1/create-qr-code/?size=150x150&data=HELLOKEVIN");

			//make connection
			URLConnection urlc = url.openConnection();

			//use post mode
			urlc.setDoOutput(true);
			urlc.setAllowUserInteraction(false);

			//send query
			PrintStream ps = new PrintStream(urlc.getOutputStream());
			ps.print("");
			ps.close();

			//get result
			BufferedReader br = new BufferedReader(new InputStreamReader(urlc
					.getInputStream()));
			String l = null;
			while ((l = br.readLine()) != null) {
				test += l;
				System.out.println(l);
			}
			LOGGER.info("TEST : " + test);
			br.close();

			String base64Image = test.split(",")[1];
			byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
			BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageBytes));
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

}
