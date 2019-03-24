package com.csc625.checkin.service;

import com.csc625.checkin.model.pojo.QRCode;
import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.model.pojo.User;

import java.util.List;

public interface QRService
{
    List <QRCode> getAllQRCodes();
    QRCode addQRCode(QRCode qrCode);
    Boolean test();
}
