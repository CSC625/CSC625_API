package com.csc625.checkin.model.dto;

public class AccountLinkStudentDTO 
{
	private int userID;
    private int studentID;
        
    public AccountLinkStudentDTO(){}
    public AccountLinkStudentDTO(int userID, int studentID)
    {
        this.userID = userID;
        this.studentID = studentID;
    }
    
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
    
    
    
}
