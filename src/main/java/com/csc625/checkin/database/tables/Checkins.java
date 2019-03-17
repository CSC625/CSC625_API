/*
 * This file is generated by jOOQ.
*/
package com.csc625.checkin.database.tables;


import com.csc625.checkin.database.Checkin;
import com.csc625.checkin.database.Indexes;
import com.csc625.checkin.database.Keys;
import com.csc625.checkin.database.tables.records.CheckinsRecord;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Checkins extends TableImpl<CheckinsRecord> {

    private static final long serialVersionUID = 972417445;

    /**
     * The reference instance of <code>checkin.checkins</code>
     */
    public static final Checkins CHECKINS = new Checkins();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CheckinsRecord> getRecordType() {
        return CheckinsRecord.class;
    }

    /**
     * The column <code>checkin.checkins.ID</code>.
     */
    public final TableField<CheckinsRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>checkin.checkins.Student_ID</code>.
     */
    public final TableField<CheckinsRecord, Integer> STUDENT_ID = createField("Student_ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>checkin.checkins.Check_In_Date</code>.
     */
    public final TableField<CheckinsRecord, Date> CHECK_IN_DATE = createField("Check_In_Date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * Create a <code>checkin.checkins</code> table reference
     */
    public Checkins() {
        this(DSL.name("checkins"), null);
    }

    /**
     * Create an aliased <code>checkin.checkins</code> table reference
     */
    public Checkins(String alias) {
        this(DSL.name(alias), CHECKINS);
    }

    /**
     * Create an aliased <code>checkin.checkins</code> table reference
     */
    public Checkins(Name alias) {
        this(alias, CHECKINS);
    }

    private Checkins(Name alias, Table<CheckinsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Checkins(Name alias, Table<CheckinsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Checkin.CHECKIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.CHECKINS_PRIMARY, Indexes.CHECKINS_STUDENT_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CheckinsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CHECKINS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CheckinsRecord> getPrimaryKey() {
        return Keys.KEY_CHECKINS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CheckinsRecord>> getKeys() {
        return Arrays.<UniqueKey<CheckinsRecord>>asList(Keys.KEY_CHECKINS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<CheckinsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CheckinsRecord, ?>>asList(Keys.CHECKINS_IDFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Checkins as(String alias) {
        return new Checkins(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Checkins as(Name alias) {
        return new Checkins(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Checkins rename(String name) {
        return new Checkins(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Checkins rename(Name name) {
        return new Checkins(name, null);
    }
}
