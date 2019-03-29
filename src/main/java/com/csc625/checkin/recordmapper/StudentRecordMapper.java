package com.csc625.checkin.recordmapper;

import static com.csc625.checkin.database.tables.Student.STUDENT;

import com.csc625.checkin.model.pojo.User;
import javassist.bytecode.stackmap.TypeData;
import org.jooq.Record;
import org.jooq.RecordMapper;

import com.csc625.checkin.model.pojo.Student;

import java.util.logging.Logger;

public class StudentRecordMapper implements RecordMapper<Record,Student>
{
    private static final Logger LOGGER = Logger.getLogger(TypeData.ClassName.class.getName());

    public Student map(Record r) 
    {
        User user = new User();

        LOGGER.info("VALUE:" + r.getValue(STUDENT.ACTIVE));
        LOGGER.info("VALUE:" + r.getValue(STUDENT.ID));
        LOGGER.info("TEST:" + STUDENT.USER_ID);
        LOGGER.info("NAME:" + r.getValue(STUDENT.FIRSTNAME));
        LOGGER.info("VALUE:" + r.getValue(STUDENT.USER_ID));

        if(r.getValue(STUDENT.USER_ID) != null) {
            user = new User(r.getValue(STUDENT.USER_ID));
        }

        return new Student(r.getValue(STUDENT.ID),
                            r.getValue(STUDENT.ACTIVE),
                            r.getValue(STUDENT.FIRSTNAME),
                            r.getValue(STUDENT.LASTNAME),
                            user);
    }
}