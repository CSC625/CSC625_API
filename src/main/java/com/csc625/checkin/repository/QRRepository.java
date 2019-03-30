package com.csc625.checkin.repository;

import com.csc625.checkin.model.pojo.QRCode;
import org.springframework.data.repository.CrudRepository;


public interface QRRepository extends CrudRepository<QRCode, String>{
}
