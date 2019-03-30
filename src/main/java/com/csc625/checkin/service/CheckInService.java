package com.csc625.checkin.service;

import com.csc625.checkin.model.pojo.CheckIn;

import java.util.List;

public interface CheckInService {
    CheckIn logCheckIn(String codeText);
	List <CheckIn> getAllCheckIns();
}
