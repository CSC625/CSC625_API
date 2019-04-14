package com.csc625.checkin.repository.impl;

import com.csc625.checkin.model.pojo.CheckIn;
import com.csc625.checkin.recordmapper.CheckInRecordMapper;
import com.csc625.checkin.repository.CheckInRepository;
import com.csc625.checkin.service.DBConnection;
import javassist.bytecode.stackmap.TypeData.ClassName;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import static com.csc625.checkin.database.Tables.CHECKINS;
import static com.csc625.checkin.database.Tables.QRCODE;
import static com.csc625.checkin.database.Tables.STUDENT;

@Repository("checkInRepository")
public class CheckInRepositoryImpl implements CheckInRepository {

	DSLContext dslContext = DBConnection.getConnection();
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public <S extends CheckIn> S save(S checkIn) {
		int studentID = checkIn.getStudent().getStudentID();
		Date today = new java.sql.Date(Calendar.getInstance().getTimeInMillis());

		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sq = new java.sql.Timestamp(utilDate.getTime());

		CheckIn inCheckIn = this.dslContext.insertInto(CHECKINS,
						CHECKINS.STUDENT_ID,
						CHECKINS.CHECK_IN_DATE)
						.values(studentID, sq)
						.returning(CHECKINS.ID, CHECKINS.STUDENT_ID, CHECKINS.CHECK_IN_DATE)
						.fetchOne()
						.map(new CheckInRecordMapper());

		CheckIn newCheckIn = (CheckIn)checkIn;
		newCheckIn.setCheckInID(newCheckIn.getCheckInID());
        if(newCheckIn != null){
        	   LOGGER.info("Successfully added CheckIn to DB: " + newCheckIn.toString());
        }
        
		return (S)newCheckIn;

	}

	@Override
	public <S extends CheckIn> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckIn findOne(String id) {
		/*List<User> users = new ArrayList<User>();
		users = this.dslContext.select(USER.ID,
						USER.EMAIL,
						USER.UID,
						USER.LAST_LOGIN,
						USER.INVALID_ATTEMPTS,
						USER.ACTIVE,
						USER.ROLE_ID,
						ROLE.NAME,
						USER.FIRSTNAME,
						USER.LASTNAME)
					.from(USER)
					.join(ROLE).on(USER.ROLE_ID.eq(ROLE.ID))
					.where(USER.UID.eq(id))
					.fetch()
					.map(new UserRecordMapper());
		if (users.size() == 1) {
			return users.get(0);
		}*/
		return null;
	}

	@Override
	public boolean exists(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<CheckIn> findAll() {
		List<CheckIn> checkIns = new ArrayList<CheckIn>();
		checkIns = this.dslContext.select(CHECKINS.ID,
						CHECKINS.STUDENT_ID,
						CHECKINS.CHECK_IN_DATE,
						STUDENT.FIRSTNAME,
						STUDENT.LASTNAME)
                             .from(CHECKINS)
							 .join(STUDENT).on(STUDENT.ID.eq(CHECKINS.ID))
                             .fetch()
                             .map(new CheckInRecordMapper());
        return checkIns;
	}

	@Override
	public Iterable<CheckIn> findAll(Iterable<String> ids) {
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
	public void delete(CheckIn entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends CheckIn> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
