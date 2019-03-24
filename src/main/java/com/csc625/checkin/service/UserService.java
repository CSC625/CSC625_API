package com.csc625.checkin.service;

import java.util.List;

import com.csc625.checkin.model.dto.AccountDetailsDTO;
import com.csc625.checkin.model.pojo.User;

public interface UserService {
    User addUser(AccountDetailsDTO accountDetails);
	List <User> getAllUsers(); 
    User getUserByUID(String uid);
    Boolean logUserLogin(String uid);
}
