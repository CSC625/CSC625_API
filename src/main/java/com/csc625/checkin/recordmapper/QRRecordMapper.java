package com.csc625.checkin.recordmapper;

import com.csc625.checkin.model.pojo.QRCode;
import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.model.pojo.User;
import javassist.bytecode.stackmap.TypeData;
import org.jooq.Record;
import org.jooq.RecordMapper;

import java.sql.Blob;
import java.util.logging.Logger;

import static com.csc625.checkin.database.Tables.STUDENT;
import static com.csc625.checkin.database.tables.Qrcode.QRCODE;

public class QRRecordMapper implements RecordMapper<Record, QRCode>{
	private static final Logger LOGGER =
			Logger.getLogger(TypeData.ClassName.class.getName());


	@Override
	public QRCode map(Record r) {
		Student student = new Student();
		student.setStudentID(r.getValue(QRCODE.STUDENT_ID));
		student.setStudentFirstName(r.getValue(STUDENT.FIRSTNAME));
		student.setStudentLastName(r.getValue(STUDENT.LASTNAME));

		return new QRCode(
				r.getValue(QRCODE.ID),
				student,
				r.getValue(QRCODE.ACTIVE),
				r.getValue(QRCODE.CODE));
	}

}
