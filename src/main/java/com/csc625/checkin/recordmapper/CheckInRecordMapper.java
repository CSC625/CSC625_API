package com.csc625.checkin.recordmapper;

import com.csc625.checkin.model.pojo.CheckIn;
import com.csc625.checkin.model.pojo.Student;
import org.jooq.Record;
import org.jooq.RecordMapper;

import static com.csc625.checkin.database.tables.Checkins.CHECKINS;
import static com.csc625.checkin.database.tables.Student.STUDENT;

public class CheckInRecordMapper implements RecordMapper<Record, CheckIn>{
	
	
	@Override
	public CheckIn map(Record r) {

		Student student = new Student(r.getValue(CHECKINS.STUDENT_ID));
		student.setStudentFirstName(r.getValue(STUDENT.FIRSTNAME));
		student.setStudentLastName(r.getValue(STUDENT.LASTNAME));

		return new CheckIn(
				r.getValue(CHECKINS.ID),
				student,
				r.getValue(CHECKINS.CHECK_IN_DATE));
	}

}
