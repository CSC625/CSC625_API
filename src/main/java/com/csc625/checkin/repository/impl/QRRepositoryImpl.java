package com.csc625.checkin.repository.impl;

import com.csc625.checkin.model.pojo.QRCode;
import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.recordmapper.QRRecordMapper;
import com.csc625.checkin.recordmapper.UserRecordMapper;
import com.csc625.checkin.repository.QRRepository;
import com.csc625.checkin.repository.UserRepository;
import com.csc625.checkin.service.DBConnection;
import javassist.bytecode.stackmap.TypeData.ClassName;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.jooq.DSLContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.csc625.checkin.database.Tables.QRCODE;

@Repository("QRRepository")
public class QRRepositoryImpl implements QRRepository {

	DSLContext dslContext = DBConnection.getConnection();
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public <S extends QRCode> S save(S qrCode) {
		LOGGER.info("HIT SAVE QR CODE ");

		Student student = new Student();
		student.setStudentID(1);
		/*long length = 0;
		byte[] bytes = null;

		try {
			length = qrCode.getCode().length();
			bytes = qrCode.getCode().getBytes(1, (int)length);
		} catch(Exception e) {
			LOGGER.info("ERROR GETTING BLOB LENGTH: ");
		}*/


		this.dslContext.insertInto(QRCODE,
				QRCODE.STUDENT_ID,
				QRCODE.ACTIVE,
				QRCODE.CODE)
				.values(student.getStudentID(), "Y", qrCode.getCode())
				.returning(QRCODE.ID)
				//.fetchOne()
				//.map(new UserRecordMapper());
				.execute();

		QRCode newQRCode = (QRCode)qrCode;
		if(newQRCode != null){
			LOGGER.info("Successfully added QRCode to DB: " + newQRCode.toString());
		}

		return (S)newQRCode;

	}

	@Override
	public <S extends QRCode> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QRCode findOne(String id) {
		LOGGER.info("In findOne impl: " + id);
		List<QRCode> qrCodes = new ArrayList<QRCode>();
		qrCodes = this.dslContext.select(QRCODE.ID,
				QRCODE.STUDENT_ID,
				QRCODE.ACTIVE,
				QRCODE.CODE)
					.from(QRCODE)
					.where(QRCODE.ID.eq(Integer.valueOf(id)))
					.fetch()
					.map(new QRRecordMapper());
		if (qrCodes.size() == 1) {
			LOGGER.info("In findOne impl found one: ");
			return qrCodes.get(0);
		}
		LOGGER.info("In findOne impl DIDNT FIND ONE: ");
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<QRCode> findAll() {
		List<QRCode> qrCodes = new ArrayList<QRCode>();
		qrCodes = this.dslContext.select(QRCODE.ID,
							QRCODE.STUDENT_ID,
							QRCODE.ACTIVE,
							QRCODE.CODE)
                             .from(QRCODE)
                             .fetch()
                             .map(new QRRecordMapper());

		try {
			File targetFile = new File("C:\\\\Users\\\\Zehzen\\\\Desktop\\\\test.png");
			try (FileOutputStream stream = new FileOutputStream("C:\\\\Users\\\\Zehzen\\\\Desktop\\\\test.png")) {
				stream.write(qrCodes.get(1).getCode());
			}
		}catch(Exception e) {
			LOGGER.info("ERROR IN TEST FILE WRITE OUT");
		}

        return qrCodes;
	}

	@Override
	public Iterable<QRCode> findAll(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(QRCode entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends QRCode> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
