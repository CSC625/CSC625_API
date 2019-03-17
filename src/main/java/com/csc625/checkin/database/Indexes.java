/*
 * This file is generated by jOOQ.
*/
package com.csc625.checkin.database;


import com.csc625.checkin.database.tables.Checkins;
import com.csc625.checkin.database.tables.Qrcode;
import com.csc625.checkin.database.tables.Student;
import com.csc625.checkin.database.tables.User;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.AbstractKeys;


/**
 * A class modelling indexes of tables of the <code>checkin</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index CHECKINS_PRIMARY = Indexes0.CHECKINS_PRIMARY;
    public static final Index CHECKINS_STUDENT_ID = Indexes0.CHECKINS_STUDENT_ID;
    public static final Index QRCODE_PRIMARY = Indexes0.QRCODE_PRIMARY;
    public static final Index QRCODE_STUDENT_ID = Indexes0.QRCODE_STUDENT_ID;
    public static final Index STUDENT_PRIMARY = Indexes0.STUDENT_PRIMARY;
    public static final Index STUDENT_USER_ID = Indexes0.STUDENT_USER_ID;
    public static final Index USER_PRIMARY = Indexes0.USER_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 extends AbstractKeys {
        public static Index CHECKINS_PRIMARY = createIndex("PRIMARY", Checkins.CHECKINS, new OrderField[] { Checkins.CHECKINS.ID }, true);
        public static Index CHECKINS_STUDENT_ID = createIndex("Student_ID", Checkins.CHECKINS, new OrderField[] { Checkins.CHECKINS.STUDENT_ID }, false);
        public static Index QRCODE_PRIMARY = createIndex("PRIMARY", Qrcode.QRCODE, new OrderField[] { Qrcode.QRCODE.ID }, true);
        public static Index QRCODE_STUDENT_ID = createIndex("Student_ID", Qrcode.QRCODE, new OrderField[] { Qrcode.QRCODE.STUDENT_ID }, false);
        public static Index STUDENT_PRIMARY = createIndex("PRIMARY", Student.STUDENT, new OrderField[] { Student.STUDENT.ID }, true);
        public static Index STUDENT_USER_ID = createIndex("User_ID", Student.STUDENT, new OrderField[] { Student.STUDENT.USER_ID }, false);
        public static Index USER_PRIMARY = createIndex("PRIMARY", User.USER, new OrderField[] { User.USER.ID }, true);
    }
}