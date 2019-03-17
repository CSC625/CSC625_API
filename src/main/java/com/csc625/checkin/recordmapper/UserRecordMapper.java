package com.csc625.checkin.recordmapper;

import static com.csc625.checkin.database.tables.User.USER;

import org.jooq.Record;
import org.jooq.RecordMapper;

import com.csc625.checkin.model.pojo.User;

public class UserRecordMapper implements RecordMapper<Record, User>{
	
	
	@Override
	public User map(Record r) {

		return new User(
				r.getValue(USER.ID),
				r.getValue(USER.EMAIL),
				r.getValue(USER.UID),
				r.getValue(USER.LAST_LOGIN),
				0,
				r.getValue(USER.ACTIVE),
				r.getValue(USER.FIRSTNAME),
				r.getValue(USER.LASTNAME));
	}

}
