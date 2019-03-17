package com.csc625.checkin.service;

import java.util.List;

import com.csc625.checkin.model.pojo.User;

public interface UserService {
	List <User> getAllUsers(); 
    User getUserByUID(String uid);
}
