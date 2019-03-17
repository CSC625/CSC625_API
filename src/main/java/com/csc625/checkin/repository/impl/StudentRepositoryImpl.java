package com.csc625.checkin.repository.impl;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;
import static com.csc625.checkin.database.Tables.STUDENT;
import static com.csc625.checkin.database.Tables.USER;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import com.csc625.checkin.model.dto.AccountLinkStudentDTO;
import com.csc625.checkin.model.dto.StudentDTO;
import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.model.pojo.User;
import com.csc625.checkin.recordmapper.StudentRecordMapper;
import com.csc625.checkin.recordmapper.UserRecordMapper;
import com.csc625.checkin.service.DBConnection;
import com.csc625.checkin.repository.StudentRepository;


@Repository ("studentRepository")
public class StudentRepositoryImpl implements StudentRepository
{
	DSLContext dslContext = DBConnection.getConnection();
        private static final Logger LOGGER = 
                                    Logger.getLogger(ClassName.class.getName());
	
    @Override
    public long count() 
    {
        
        int studentCount = 0;  
        studentCount = this.dslContext.selectCount()
                             .from(STUDENT)
                             .fetchOne(0, int.class);
        return studentCount;
    }

    @Override
    public void delete(String arg0) 
    {
    	// TODO Auto-generated method stub
    }

    @Override
    public void delete(Student arg0) 
    {
	// TODO Auto-generated method stub
		
    }

    @Override
    public void delete(Iterable<? extends Student> arg0) 
    {
	// TODO Auto-generated method stub
    }

    @Override
    public void deleteAll() 
    {
	// TODO Auto-generated method stub
    }

    @Override
    public boolean exists(String arg0) 
    {	
    	boolean studentExists = false;
    	int studentId = Integer.parseInt(arg0);
        int studentCount = this.dslContext
                                   .selectCount()
                                   .from(STUDENT)
                                   .where(STUDENT.ID.eq(studentId))
                                   .fetchOne(0, int.class);
       
        
        if(studentCount != 0){
        	studentExists = true;
        }
        
        return studentExists;
    }

    @Override
    public Iterable<Student> findAll() 
    {
        /*List<Student> students = new ArrayList<Student>();
        students = this.dslContext.select(STUDENT.FIRST_NAME,
                                     STUDENT.LAST_NAME,
                                     STUDENT.ID,
                                     STUDENT.DATE_OF_BIRTH,
                                     STUDENT.SSN,
                                     STUDENT.ADDRESS_1,
                                     STUDENT.ADDRESS_2,
                                     STUDENT.CITY,
                                     STUDENT.STATE,
                                     STUDENT.ZIP_CODE,
                                     STUDENT.GRADE,
                                     STUDENT.MOTHER_FIRST_NAME,
                                     STUDENT.MOTHER_LAST_NAME,
                                     STUDENT.MOTHER_SSN,
                                     STUDENT.MOTHER_ADDRESS_1,
                                     STUDENT.MOTHER_ADDRESS_2,
                                     STUDENT.MOTHER_CITY, 
                                     STUDENT.MOTHER_STATE,
                                     STUDENT.MOTHER_ZIP_CODE,
                                     STUDENT.MOTHER_HOME_PHONE,
                                     STUDENT.MOTHER_CELL_PHONE,
                                     STUDENT.MOTHER_EMAIL,
                                     STUDENT.FATHER_FIRST_NAME,
                                     STUDENT.FATHER_LAST_NAME,
                                     STUDENT.FATHER_SSN,
                                     STUDENT.FATHER_ADDRESS_1,
                                     STUDENT.FATHER_ADDRESS_2,
                                     STUDENT.FATHER_CITY, 
                                     STUDENT.FATHER_STATE,
                                     STUDENT.FATHER_ZIP_CODE,
                                     STUDENT.FATHER_HOME_PHONE,
                                     STUDENT.FATHER_CELL_PHONE,
                                     STUDENT.FATHER_EMAIL)
                             .from(STUDENT)
                             .fetch()
                             .map(new StudentRecordMapper());
        return students;*/

        return null;

    }

    public Iterable<Student> findAll(Iterable<String> arg0) 
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Student findOne(String arg0) 
    {
        List<Student> students = new ArrayList<Student>();
        /*int studentId = Integer.parseInt(arg0);
        students = this.dslContext.select(STUDENT.FIRST_NAME,
                                     STUDENT.LAST_NAME,
                                     STUDENT.ID,
                                     STUDENT.DATE_OF_BIRTH,
                                     STUDENT.SSN,
                                     STUDENT.ADDRESS_1,
                                     STUDENT.ADDRESS_2,
                                     STUDENT.CITY,
                                     STUDENT.STATE,
                                     STUDENT.ZIP_CODE,
                                     STUDENT.GRADE,
                                     STUDENT.MOTHER_FIRST_NAME,
                                     STUDENT.MOTHER_LAST_NAME,
                                     STUDENT.MOTHER_SSN,
                                     STUDENT.MOTHER_ADDRESS_1,
                                     STUDENT.MOTHER_ADDRESS_2,
                                     STUDENT.MOTHER_CITY, 
                                     STUDENT.MOTHER_STATE,
                                     STUDENT.MOTHER_ZIP_CODE,
                                     STUDENT.MOTHER_HOME_PHONE,
                                     STUDENT.MOTHER_CELL_PHONE,
                                     STUDENT.MOTHER_EMAIL,
                                     STUDENT.FATHER_FIRST_NAME,
                                     STUDENT.FATHER_LAST_NAME,
                                     STUDENT.FATHER_SSN,
                                     STUDENT.FATHER_ADDRESS_1,
                                     STUDENT.FATHER_ADDRESS_2,
                                     STUDENT.FATHER_CITY, 
                                     STUDENT.FATHER_STATE,
                                     STUDENT.FATHER_ZIP_CODE,
                                     STUDENT.FATHER_HOME_PHONE,
                                     STUDENT.FATHER_CELL_PHONE,
                                     STUDENT.FATHER_EMAIL)
                             .from(STUDENT)
                             .where(STUDENT.ID.eq(studentId))
                             .fetch()
                             .map(new StudentRecordMapper());
        return students.get(0);*/

        return null;
    }
    
    private boolean isDuplicateStudentRecord(Student student)
	{
		boolean studentExists = false;
		/*int studentCount = this.dslContext
				.selectCount()
				.from(STUDENT)
				.where(STUDENT.FIRST_NAME.eq(student.getStudentFirstName()))
				.and(STUDENT.LAST_NAME.eq(student.getStudentLastName()))
				.and(STUDENT.DATE_OF_BIRTH.eq(student.getStudentDateOfBirth()))
				.fetchOne(0, int.class);
		
		if (studentCount != 0) {
			studentExists = true;
		}*/
		return studentExists;
	}
    
    @SuppressWarnings("unchecked")
    @Override
    public <S extends Student> S save(S arg0) 
    {
	// TODO Auto-generated method stub
        String studentFirstName = arg0.getStudentFirstName();
        String studentLastName = arg0.getStudentLastName();
        String studentDateOfBirth = arg0.getStudentDateOfBirth();
        
        //check for duplicate student record
        /*if(isDuplicateStudentRecord(arg0)) {
        	Student student = new Student(studentFirstName, studentLastName);
        	return (S)student;
        }
        
        Student iStudent = this.dslContext.insertInto(STUDENT, 
                STUDENT.FIRST_NAME,
                STUDENT.LAST_NAME,
                STUDENT.DATE_OF_BIRTH)
        .values(studentFirstName, studentLastName, 
                studentDateOfBirth
                )
        .returning(STUDENT.ID)
        .fetchOne()
        .map(new StudentRecordMapper());
        
        	Student newStudent = (Student)arg0;
            newStudent.setStudentId(iStudent.getStudentId());
            
	        if(newStudent != null){
	        	   LOGGER.info("Successfully added Student to DB: " + newStudent.toString());
	        }
        return (S)newStudent;*/

        return null;
    }

    @Override
    public <S extends Student> Iterable<S> save(Iterable<S> arg0) 
    {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public List<Student> findById(String id) 
    {
	return null;
    }
    
    @Override
    public Student findStudent(StudentDTO studentDto) 
    {	
                
                /*List<Student> students = new ArrayList<Student>();
                students = this.dslContext.select(STUDENT.FIRST_NAME,
                                             STUDENT.LAST_NAME,
                                             STUDENT.ID,
                                             STUDENT.DATE_OF_BIRTH,
                                             STUDENT.SSN,
                                             STUDENT.ADDRESS_1,
                                             STUDENT.ADDRESS_2,
                                             STUDENT.CITY,
                                             STUDENT.STATE,
                                             STUDENT.ZIP_CODE,
                                             STUDENT.GRADE,
                                             STUDENT.MOTHER_FIRST_NAME,
                                             STUDENT.MOTHER_LAST_NAME,
                                             STUDENT.MOTHER_SSN,
                                             STUDENT.MOTHER_ADDRESS_1,
                                             STUDENT.MOTHER_ADDRESS_2,
                                             STUDENT.MOTHER_CITY, 
                                             STUDENT.MOTHER_STATE,
                                             STUDENT.MOTHER_ZIP_CODE,
                                             STUDENT.MOTHER_HOME_PHONE,
                                             STUDENT.MOTHER_CELL_PHONE,
                                             STUDENT.MOTHER_EMAIL,
                                             STUDENT.FATHER_FIRST_NAME,
                                             STUDENT.FATHER_LAST_NAME,
                                             STUDENT.FATHER_SSN,
                                             STUDENT.FATHER_ADDRESS_1,
                                             STUDENT.FATHER_ADDRESS_2,
                                             STUDENT.FATHER_CITY, 
                                             STUDENT.FATHER_STATE,
                                             STUDENT.FATHER_ZIP_CODE,
                                             STUDENT.FATHER_HOME_PHONE,
                                             STUDENT.FATHER_CELL_PHONE,
                                             STUDENT.FATHER_EMAIL)
								 .from(STUDENT)
								 .where(STUDENT.LAST_NAME.upper().eq(studentDto.getLastName().toUpperCase()))
								 .and(STUDENT.FIRST_NAME.upper().eq(studentDto.getFirstName().toUpperCase()))
								 .and(STUDENT.DATE_OF_BIRTH.eq(studentDto.getDateOfBirth()))
								 .fetch()
								 .map(new StudentRecordMapper());
                
                if(students.isEmpty()){
                	return null;
                }
                
                return students.get(0);*/

                return null;
                
    }
    
    /**
     * findUser - finds a user with the matching UID.  Used to find primary key ID of user using the UID
     * @param UID
     */
    public int findUser(String UID)
    {
    	int userID = 0;
    	//find user ID
        /*List<User> searchUsers = new ArrayList<User>();
        searchUsers = this.dslContext.select(USER.ID, 
        									USER.ROLE_ID, 
        									USER.EMAIL,
        									USER.UID,
        									USER.LAST_LOGIN, 
        									USER.INVALID_ATTEMPTS, 
        									USER.ACTIVE)
                             .from(USER)
                             .where(USER.UID.eq(UID))
                             .fetch()
                             .map(new UserRecordMapper());
        
        
        if(!searchUsers.isEmpty())
        {
        	userID = searchUsers.get(0).getUserID();
        }*/
        
        return userID;
    }
    
    
}
