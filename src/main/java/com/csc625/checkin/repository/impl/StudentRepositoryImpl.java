package com.csc625.checkin.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javassist.bytecode.stackmap.TypeData.ClassName;
import static com.csc625.checkin.database.Tables.STUDENT;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import com.csc625.checkin.model.dto.StudentDTO;
import com.csc625.checkin.model.pojo.Student;
import com.csc625.checkin.recordmapper.StudentRecordMapper;
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
        List<Student> students = new ArrayList<Student>();
        students = this.dslContext.select(STUDENT.ID,
                STUDENT.ACTIVE,
                STUDENT.FIRSTNAME,
                STUDENT.LASTNAME,
                STUDENT.USER_ID)
                .from(STUDENT)
                .fetch()
                .map(new StudentRecordMapper());
        return students;
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
        int studentId = Integer.parseInt(arg0);
        students = this.dslContext.select(STUDENT.ID,
                STUDENT.ACTIVE,
                STUDENT.FIRSTNAME,
                STUDENT.LASTNAME,
                STUDENT.USER_ID)
                .from(STUDENT)
                .where(STUDENT.ID.eq(studentId))
                .fetch()
                .map(new StudentRecordMapper());
        return students.get(0);
    }
    
    private boolean isDuplicateStudentRecord(Student student)
	{
		boolean studentExists = false;
		int studentCount = this.dslContext
				.selectCount()
				.from(STUDENT)
				.where(STUDENT.FIRSTNAME.eq(student.getStudentFirstName()))
				.and(STUDENT.LASTNAME.eq(student.getStudentLastName()))
				//.and(STUDENT.DATE_OF_BIRTH.eq(student.getStudentDateOfBirth()))
				.fetchOne(0, int.class);
		
		if (studentCount != 0) {
			studentExists = true;
		}
		return studentExists;
	}
    
    @SuppressWarnings("unchecked")
    @Override
    public <S extends Student> S save(S arg0) 
    {
	// TODO Auto-generated method stub
        String studentFirstName = arg0.getStudentFirstName();
        String studentLastName = arg0.getStudentLastName();
        int userID = arg0.getUser().getUserID();
        
        //check for duplicate student record
        if(isDuplicateStudentRecord(arg0)) {
        	Student student = new Student(studentFirstName, studentLastName);
        	return (S)student;
        }

        this.dslContext.insertInto(STUDENT,
                STUDENT.ACTIVE,
                STUDENT.FIRSTNAME,
                STUDENT.LASTNAME,
                STUDENT.USER_ID)
        .values("Y",
                studentFirstName,
                studentLastName,
                userID
                )
        .returning(STUDENT.ID)
        .execute();

        StudentDTO s = new StudentDTO();
        s.setFirstName(studentFirstName);
        s.setLastName(studentLastName);
        Student newStudent = findStudent(s);

        if(newStudent != null){
            LOGGER.info("Successfully added Student to DB: " + newStudent.toString());
        }
        return (S)newStudent;
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
    public Student findStudent(StudentDTO studentDto) {

        List<Student> students = new ArrayList<Student>();
        students = this.dslContext.select(STUDENT.ID,
                STUDENT.ACTIVE,
                STUDENT.FIRSTNAME,
                STUDENT.LASTNAME,
                STUDENT.USER_ID)
                .from(STUDENT)
                .where(STUDENT.LASTNAME.upper().eq(studentDto.getLastName().toUpperCase()))
                .and(STUDENT.FIRSTNAME.upper().eq(studentDto.getFirstName().toUpperCase()))
                .fetch()
                .map(new StudentRecordMapper());

        if (students.isEmpty()) {
            return null;
        }

        return students.get(0);

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

    /**
     * findLinkedStudents - Find all students with records linked to a user account with UID
     * @param userID
     */
    public List<Student> findLinkedStudents(int userID)
    {
        //find students with linked student IDs
        List<Student> students = new ArrayList<Student>();
        students = this.dslContext.select(
                STUDENT.ID,
                STUDENT.ACTIVE,
                STUDENT.FIRSTNAME,
                STUDENT.LASTNAME,
                STUDENT.USER_ID)
                .from(STUDENT)
                .where(STUDENT.USER_ID.eq(userID))
                .fetch()
                .map(new StudentRecordMapper());
        return students;

    }

    @Override
    public Student findStudentByName(String name)
    {
        List<Student> students = new ArrayList<Student>();
        //int studentId = Integer.parseInt(arg0);
        students = this.dslContext.select(STUDENT.ID,
                STUDENT.ACTIVE,
                STUDENT.FIRSTNAME,
                STUDENT.LASTNAME,
                STUDENT.USER_ID)
                .from(STUDENT)
                .where(STUDENT.FIRSTNAME.concat(STUDENT.LASTNAME).upper().contains(name.toUpperCase()))
                .fetch()
                .map(new StudentRecordMapper());
        return students.get(0);
    }
    
    
}
