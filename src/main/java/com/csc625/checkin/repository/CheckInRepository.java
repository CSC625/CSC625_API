package com.csc625.checkin.repository;

import com.csc625.checkin.model.pojo.CheckIn;
import com.csc625.checkin.model.pojo.User;
import org.springframework.data.repository.CrudRepository;


public interface CheckInRepository extends CrudRepository<CheckIn, String>{
}
