package com.csc625.checkin.recordmapper;

import static com.csc625.checkin.database.tables.Student.STUDENT;

import org.jooq.Record;
import org.jooq.RecordMapper;

import com.csc625.checkin.model.pojo.Student;

public class StudentRecordMapper implements RecordMapper<Record,Student>
{
    public Student map(Record r) 
    {
        /*return new Student(r.getValue(STUDENT.FIRST_NAME),
                           r.getValue(STUDENT.LAST_NAME),
                           r.getValue(STUDENT.ID),
                           r.getValue(STUDENT.DATE_OF_BIRTH),
                           r.getValue(STUDENT.SSN),
                           r.getValue(STUDENT.ADDRESS_1),
                           r.getValue(STUDENT.ADDRESS_2),
                           r.getValue(STUDENT.CITY),
                           r.getValue(STUDENT.STATE),
                           r.getValue(STUDENT.ZIP_CODE),
                           r.getValue(STUDENT.GRADE),
                           r.getValue(STUDENT.MOTHER_FIRST_NAME),
                           r.getValue(STUDENT.MOTHER_LAST_NAME),
                           r.getValue(STUDENT.MOTHER_SSN),
                           r.getValue(STUDENT.MOTHER_ADDRESS_1),
                           r.getValue(STUDENT.MOTHER_ADDRESS_2),
                           r.getValue(STUDENT.MOTHER_CITY),
                           r.getValue(STUDENT.MOTHER_STATE),
                           r.getValue(STUDENT.MOTHER_ZIP_CODE),
                           r.getValue(STUDENT.MOTHER_HOME_PHONE),
                           r.getValue(STUDENT.MOTHER_CELL_PHONE),
                           r.getValue(STUDENT.MOTHER_EMAIL),
                           r.getValue(STUDENT.FATHER_FIRST_NAME),
                           r.getValue(STUDENT.FATHER_LAST_NAME),
                           r.getValue(STUDENT.FATHER_SSN),
                           r.getValue(STUDENT.FATHER_ADDRESS_1),
                           r.getValue(STUDENT.FATHER_ADDRESS_2),
                           r.getValue(STUDENT.FATHER_CITY),
                           r.getValue(STUDENT.FATHER_STATE),
                           r.getValue(STUDENT.FATHER_ZIP_CODE),
                           r.getValue(STUDENT.FATHER_HOME_PHONE),
                           r.getValue(STUDENT.FATHER_CELL_PHONE),
                           r.getValue(STUDENT.FATHER_EMAIL));*/
        return null;
    }
}