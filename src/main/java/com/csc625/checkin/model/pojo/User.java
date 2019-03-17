package com.csc625.checkin.model.pojo;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {

	@Id
	private int userID;
	private String email;
	private String uid;
	private Date lastLogin;
	private int invalidAttempts;
	private String active;
	private String firstName;
	private String lastName;

	public User() {

	}

	public User(int userID, String email, String uid, Date lastLogin, int invalidAttempts, String active, String firstName, String lastName) {
		this.userID = userID;
		this.email = email;
		this.uid = uid;
		this.lastLogin = lastLogin;
		this.invalidAttempts = invalidAttempts;
		this.active = active;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public User(int userID){
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getInvalidAttempts() {
		return invalidAttempts;
	}

	public void setInvalidAttempts(int invalidAttempts) {
		this.invalidAttempts = invalidAttempts;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	/*public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", email=" + email + ", uid=" + uid
				+ ", lastLogin=" + lastLogin + ", invalidAttempts="
				+ invalidAttempts + ", active=" + active + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

}
