package com.csc625.checkin.repository;

import org.springframework.data.repository.CrudRepository;

import com.csc625.checkin.model.pojo.User;


public interface UserRepository extends CrudRepository<User, String>{
    Boolean logUserLogin(String uid);
}
