package com.csc625.checkin.repository.impl;

import static com.csc625.checkin.database.Tables.USER;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.jooq.DSLContext;

import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.recordmapper.UserRecordMapper;
import com.csc625.checkin.repository.UserRepository;
import com.csc625.checkin.service.DBConnection;

import javassist.bytecode.stackmap.TypeData.ClassName;

public class UserRepositoryImpl implements UserRepository {

	DSLContext dslContext = DBConnection.getConnection();
	private static final Logger LOGGER = Logger.getLogger(ClassName.class.getName());

	@SuppressWarnings("unchecked")
	@Override
	public <S extends User> S save(S user) {
		String username = user.getEmail();
		String uid = user.getUid();
		Date lastLogin = user.getLastLogin();
		int invalidAttempts = user.getInvalidAttempts();
		String active = user.getActive();
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		
		User inUser = this.dslContext.insertInto(USER,
						USER.EMAIL,
						USER.UID,
						USER.LAST_LOGIN,
						USER.ACTIVE,
						USER.FIRSTNAME,
						USER.LASTNAME)
						.values(username, uid, lastLogin, active, firstName, lastName)
						.returning(USER.ID, USER.EMAIL, USER.UID, USER.LAST_LOGIN, USER.ACTIVE, USER.FIRSTNAME, USER.LASTNAME)
						.fetchOne()
						.map(new UserRecordMapper());
		
        User newUser = (User)user;
        newUser.setUserID(inUser.getUserID());
        if(newUser != null){
        	   LOGGER.info("Successfully added User to DB: " + newUser.toString());
        }
        
		return (S)newUser;

	}

	@Override
	public <S extends User> Iterable<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(String id) {
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
	public Iterable<User> findAll() {
		List<User> users = new ArrayList<User>();
		users = this.dslContext.select(USER.ID,
						USER.EMAIL,
						USER.UID,
						USER.LAST_LOGIN,
						USER.ACTIVE,
						USER.FIRSTNAME,
						USER.LASTNAME)
                             .from(USER)
                             .fetch()
                             .map(new UserRecordMapper());
        return users;
	}

	@Override
	public Iterable<User> findAll(Iterable<String> ids) {
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
	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public Boolean logUserLogin(String id) {
		return true;
	}

}
