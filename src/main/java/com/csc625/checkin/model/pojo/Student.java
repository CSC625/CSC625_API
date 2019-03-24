package com.csc625.checkin.model.pojo;

import java.sql.Blob;
import javax.persistence.*;

import lombok.Data;

@Entity
public @Data class Student 
{
    @Id
    private int studentID;
    private String studentFirstName, studentLastName, active;
    //private int userID;
    @OneToOne
    @JoinColumn(name = "Student_ID")
    private User user;
 
    public Student() {}
 
    public Student(int studentID, String active, String studentFirstName, String studentLastName, User user)
    {
        this.studentID = studentID;
        this.active = active;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.user = user;
    }
    
    public Student(int studentID)
    {
    	this.studentID = studentID;
    }
    
    public Student(String firstName, String lastName) {
    	this.studentFirstName = firstName;
    	this.studentLastName = lastName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public String toString() 
    {
        return "Student [studentID = " + studentID + ", firstName = " + studentFirstName+
                ",lastName = " + studentLastName + ",active = "+ active +
                ", user = " + user +
                "]";
    }
}
