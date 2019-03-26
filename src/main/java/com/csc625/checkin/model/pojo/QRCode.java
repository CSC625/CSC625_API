package com.csc625.checkin.model.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.awt.*;
import java.sql.Blob;
import java.sql.Date;

@Entity
public class QRCode {

	@Id
	private int qrID;
	@OneToOne
	@JoinColumn(name = "Student_ID")
	private Student student;
	private String active;
	private byte[] code;

	public QRCode() {

	}

	public QRCode(int qrID, Student student, String active, byte[] code) {
		this.qrID = qrID;
		this.student = student;
		this.active = active;
		this.code = code;
	}

	public QRCode(int qrID){
		this.qrID = qrID;
	}

	public int getQrID() {
		return qrID;
	}

	public void setQrID(int qrID) {
		this.qrID = qrID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public byte[] getCode() {
		return code;
	}

	public void setCode(byte[] code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "QRCode [qrID=" + qrID + ", active=" + active + ", student=" + student
				+ ", code=" + code + "]";
	}

}
