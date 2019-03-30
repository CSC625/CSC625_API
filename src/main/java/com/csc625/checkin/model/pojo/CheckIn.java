package com.csc625.checkin.model.pojo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
public class CheckIn {

	@Id
	private int checkInID;
	@OneToOne
	@JoinColumn(name = "Student_ID")
	private Student student;
	private Timestamp checkInDate;

	public CheckIn() {

	}

	public CheckIn(int checkInID, Student student, Timestamp checkInDate) {
		this.checkInID = checkInID;
		this.student = student;
		this.checkInDate = checkInDate;
	}

	public CheckIn(Student student) {
		this.student = student;
	}

	public int getCheckInID() {
		return checkInID;
	}

	public void setCheckInID(int checkInID) {
		this.checkInID = checkInID;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Timestamp getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Timestamp checkInDate) {
		this.checkInDate = checkInDate;
	}

	@Override
	public String toString() {
		return "CheckIn [checkInID=" + checkInID + ", student=" + student + ", checkInDate=" + checkInDate + "]";
	}

}
